package church.ruse.data;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Messaging {

  private Sender sender;
  private Recipient recipient;
  private Date timestamp;
  private Message message;
}
