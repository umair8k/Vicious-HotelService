package hotelService.Enitity;

import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetails {

	@Id
	private Long id;
	private Double roomPrice;
	private Integer roomNo;
	private String description;
	private boolean roomStatus;
	private boolean isEnable;
	private Integer occupancy;
	
	@OneToOne
	private RoomsCategory roomsCategory;
	
	@OneToOne
	private HotelNames hotelNames;
	

	
	
}
