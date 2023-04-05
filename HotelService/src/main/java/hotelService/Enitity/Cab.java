package hotelService.Enitity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;



@Data
@Entity
public class Cab {
	@Id
	private Long id;
	private Double price;
	@OneToOne
private Locations locations ;

@OneToOne
private SourceName sourceName;

@OneToOne
private DestinationName destinationName;
}

