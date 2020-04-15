package church.ruse.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Messaging {

  private Sender sender;
  private Recipient recipient;
  private int timestamp;
  private Message message;
}
