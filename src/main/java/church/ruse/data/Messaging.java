package church.ruse.data;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Messaging {

  private Sender sender;
  private Recipient recipient;
  private Instant timestamp;
  private Message message;
}
