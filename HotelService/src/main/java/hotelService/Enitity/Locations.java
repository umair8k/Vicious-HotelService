package hotelService.Enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Locations {

	   
	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    
	    private Long id;
	    private String cityName;
	    private String address;
	    }


