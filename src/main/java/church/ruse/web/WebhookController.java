package church.ruse.web;

import church.ruse.data.MessengerEvent;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/webhook")
public class WebhookController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Value("${fbbot.verifytoken}")
  private String verifyToken;

  @Post
  @Consumes(MediaType.APPLICATION_JSON)
  public HttpResponse processEvent(@Body MessengerEvent event) {
    if (event.getObject().equals("page")) {
      logger.info("Got a new webhook event: {} {}", event,
          event.getEntry().get(0).getMessaging().get(0).getRecipient().getId());
      return HttpResponse.ok().body("EVENT_RECEIVED");
    } else {
      return HttpResponse.notFound();
    }
  }

  @Get
  public HttpResponse verifyToken(
      @QueryValue("hub.mode") String hubMode,
      @QueryValue("hub.verify_token") String requestToken,
      @QueryValue("hub.challenge") String challenge
  ) {
    if (hubMode != null && requestToken != null) {
      if (hubMode.equals("subscribe") && requestToken.equals(verifyToken)) {
        return HttpResponse.ok(challenge);
      } else {
        return HttpResponse.status(HttpStatus.FORBIDDEN);
      }
    } else {
      return HttpResponse.badRequest();
    }
  }
}
