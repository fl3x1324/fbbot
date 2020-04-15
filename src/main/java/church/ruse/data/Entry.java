package church.ruse.data;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Entry {

  private String id;
  private Date time;
  private List<Messaging> messaging;
}
