package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.Rooms;
import hotelService.Repository.RoomsRepo;



@Service 

public class RoomsServiceImpl implements RoomsService  {
    
	
	@Autowired
	  private RoomsRepo roomsRepo;
	
	 @Override
	public List<Rooms> findAll() {
		return roomsRepo.findAll();
	}

	@Override
	public void updateRooms(Rooms rooms) throws BadRequestException{
		try {
			roomsRepo.save(rooms);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
		
	}

	@Override
	public Rooms findById(Long id) throws ResourceNotFoundException {
        return roomsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	@Override
	public void deleteByRoomsId(Long id) {
		roomsRepo.deleteById(id);
		
	}

}
