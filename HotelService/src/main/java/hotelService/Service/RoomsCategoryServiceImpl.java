package hotelService.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.RoomsCategory;
import hotelService.Repository.RoomsCategoryRepo;


@Service
public class RoomsCategoryServiceImpl implements RoomsCategoryService {

	@Autowired 
	
	 private RoomsCategoryRepo roomsCategoryRepo;
	
	@Override
	public List<RoomsCategory> findAll() {
		return roomsCategoryRepo.findAll();
	}

	@Override
	public void updateRoomsCategory(RoomsCategory roomsCategory) throws BadRequestException{
		try {
			roomsCategoryRepo.save(roomsCategory);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
		
	}

	@Override
	public RoomsCategory findById(Long id) throws ResourceNotFoundException {
        return roomsCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	@Override
	public void deleteRoomCategoryById(Long id) {
		roomsCategoryRepo.deleteById(id);
		
	}

	/*
	
	@Override
	public String uploadImage(MultipartFile file) throws IOException {

		RoomsCategory rc = roomsCategoryRepo.save(RoomsCategory.builder().image(file.getBytes()).build());

		if (rc != null) {

			return "uploaded successfully";
		}
		return null;
	}

	@Override
	public Optional<RoomsCategory> downloadimage(Long id) {
		Optional<RoomsCategory> rc = roomsCategoryRepo.findById(id);
		return rc;
  }

	@Override
	public RoomsCategory getJson(RoomsCategory roomsCategory, MultipartFile file) throws IOException {
        roomsCategory.setImage(file.getBytes());
       RoomsCategory rc = this.roomsCategoryRepo.save(roomsCategory);
       return rc;
    }
		*/
	}
