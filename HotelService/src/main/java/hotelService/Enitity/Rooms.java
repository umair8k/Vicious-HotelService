package hotelService.Enitity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Rooms {
	
	    @Id
	    private Long id;
	    private String totalRooms;
	     
	    @OneToOne
	     private RoomsCategory roomscategory;
	    
	   
	    
	    @OneToOne
	     private HotelNames hotelnames;


}
