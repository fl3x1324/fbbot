package church.ruse.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Attachment {

  private String type;
  private MessagePayload payload;
}
