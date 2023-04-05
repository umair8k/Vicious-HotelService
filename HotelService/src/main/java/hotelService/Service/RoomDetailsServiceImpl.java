package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.RoomDetails;
import hotelService.Repository.RoomDetailsRepo;
import hotelService.Repository.RoomsCategoryRepo;


@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

	@Autowired
	private RoomDetailsRepo roomDetailsRepo;
	
	@Autowired
	
	private RoomsCategoryRepo roomsCategoryRepo;
	
	@Override
	public List<RoomDetails> findAll() {
		return roomDetailsRepo.findAll();
	}

	@Override
	public void updateRoomDetails(RoomDetails roomDetails) throws BadRequestException{
		try {
			roomDetailsRepo.save(roomDetails);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}

	@Override
	public RoomDetails findById(Long id) throws ResourceNotFoundException {
        return roomDetailsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	@Override
	public void deleteByRoomDetailsId(Long id) {
		roomDetailsRepo.deleteById(id);
		
	}

	@Override
	public ResponseEntity<List<RoomDetails>> getroomCategory(String roomType) {
        return new ResponseEntity<List<RoomDetails>>(roomDetailsRepo.findByRoomsCategory(roomsCategoryRepo.findByroomType(roomType)),HttpStatus.OK);

	}

}
