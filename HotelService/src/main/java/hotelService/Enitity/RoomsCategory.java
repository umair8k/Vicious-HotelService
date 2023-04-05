package hotelService.Enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomsCategory {
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	
	 @Id
	    private Long id;
	    private String roomType;
	    private Boolean AC;
	    
	   private String description;
	   private String guest;
	   private String roomSize;  
	   @Lob
		private byte[] image;
}
