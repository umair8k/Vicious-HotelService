package hotelService.Service;

import java.util.List;



import hotelService.Enitity.Rooms;



public interface RoomsService {

	
	public List<Rooms> findAll();
	
	public void updateRooms( Rooms rooms);
	
	public Rooms findById(Long id);
	
	public void deleteByRoomsId(Long id);
}
