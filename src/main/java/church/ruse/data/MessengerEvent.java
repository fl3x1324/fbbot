package church.ruse.data;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessengerEvent {

  private String object;
  private List<Entry> entry;
}
