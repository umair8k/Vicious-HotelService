//

package hotelService.Enitity;
import java.util.HashSet;
import java.util.Set;
//import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelNames {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long hotelId;
	private String hotelName;
	
	private String abouthotel;
	private Long  phnNumber;
	private String email;
	 
	@Lob
	private byte[] image;
	
	private String hotelHighlights;

	
	@OneToOne
	private HotelCategory hotelCategory;
	
//	@ManyToOne
//	private RoomsCategory roomsCategory;

	@OneToOne
	@JoinColumn(name = "location_id")
	private Locations location;
 
	@EqualsAndHashCode.Exclude
	@ToString.Exclude

	//@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "displayActivites", joinColumns = { @JoinColumn(name = "hotelNames_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "activity_id") })
	private Set<Activities> assignedActivities=new HashSet<>();
}
