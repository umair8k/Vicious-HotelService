package hotelService.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import hotelService.Enitity.RoomDetails;



public interface RoomDetailsService {
	
	public List<RoomDetails> findAll();
	
	public void updateRoomDetails( RoomDetails roomDetails);
	
	public RoomDetails findById(Long id) ;
	
	public void deleteByRoomDetailsId(Long id);
	
	public ResponseEntity<List<RoomDetails>> getroomCategory(String roomType);
	

}
