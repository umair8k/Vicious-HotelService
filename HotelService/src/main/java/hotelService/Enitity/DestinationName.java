package hotelService.Enitity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DestinationName {
	@Id
	private Integer id;
	private String destinationName;
}
