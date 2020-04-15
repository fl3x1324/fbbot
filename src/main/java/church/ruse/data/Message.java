package church.ruse.data;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

  private String mid;
  private String text;
  private List<Attachment> attachments;
}
