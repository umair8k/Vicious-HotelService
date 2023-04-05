package hotelService.Service;

import java.util.List;
import java.util.Optional;



import org.springframework.web.multipart.MultipartFile;

import hotelService.Enitity.RoomsCategory;



public interface RoomsCategoryService {
	
	public List<RoomsCategory> findAll();
	
	public void updateRoomsCategory( RoomsCategory roomsCategory);
	
	public RoomsCategory findById(Long id);
	
	public void deleteRoomCategoryById(Long id);
	
	
	/*
	public String uploadImage(MultipartFile file);
	
	public Optional<RoomsCategory> downloadimage(Long id);
	
	public  RoomsCategory getJson(RoomsCategory roomsCategory, MultipartFile file);
	
	*/

}
