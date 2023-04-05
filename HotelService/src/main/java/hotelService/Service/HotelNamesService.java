package hotelService.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;



import hotelService.Enitity.HotelNames;



public interface HotelNamesService {

	
	public List<HotelNames> findAll();
	
	public void updateHotelNames( HotelNames hotelNames);
	
	public HotelNames findById(Long id);
	
	public void deleteByHotelNameId(Long id) ;
	
	public HotelNames assignActivityToHotel(Long hotelId, Long activityId);
	
	public ResponseEntity<List<HotelNames>> findByResort(String categoryName);
	
	public ResponseEntity<List<HotelNames>> findBycityName(String cityName);
	
	//public ResponseEntity<List<HotelCategoryResponse>>findByCategory(String categoryName);
	
	//public  HotelNames getJson(HotelNames hotelnames, MultipartFile file, long locId,long catId);
}
