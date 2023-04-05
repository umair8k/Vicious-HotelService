package hotelService.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.Activities;
import hotelService.Enitity.HotelCategory;
import hotelService.Enitity.HotelNames;
import hotelService.Enitity.Locations;
import hotelService.Repository.ActivitiesRepo;
import hotelService.Repository.HotelCategoryRepo;
import hotelService.Repository.HotelNamesRepo;
import hotelService.Repository.LocationsRepo;

@Service 
public class HotelNamesServiceImpl  implements HotelNamesService{

	@Autowired
	  private HotelNamesRepo hotelNamesRepo;
	
	@Autowired
	private ActivitiesRepo activitiesRepo;
	
	@Autowired
	private HotelCategoryRepo hotelCategoryRepo;
	
	@Autowired
	
	private LocationsRepo locationsRepo;
	
	
	
	
	@Override
	public List<HotelNames> findAll() {
		return hotelNamesRepo.findAll();
	}

	@Override
	public void updateHotelNames(HotelNames hotelNames) throws BadRequestException{
		try {
			hotelNamesRepo.save(hotelNames);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}

	@Override
	public HotelNames findById(Long id) throws ResourceNotFoundException {
        return hotelNamesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	@Override
	public void deleteByHotelNameId(Long id) {
		hotelNamesRepo.deleteById(id);
		
	}

	@Override
	public HotelNames assignActivityToHotel(Long hotelId, Long activityId) {
		Set<Activities> activitiesSet = null;
        HotelNames  hotelNames= hotelNamesRepo.findById(hotelId).get();
        Activities activities= activitiesRepo.findById(activityId).get();
        activitiesSet =  hotelNames.getAssignedActivities();
        activitiesSet.add(activities);
        hotelNames.setAssignedActivities(activitiesSet); 
        return hotelNamesRepo.save(hotelNames);
	}

	@Override
	public ResponseEntity<List<HotelNames>> findByResort(String categoryName) {
		return new ResponseEntity<List<HotelNames>>(hotelNamesRepo.findByHotelCategory(hotelCategoryRepo.findByCategoryName(categoryName).get(0)),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<HotelNames>> findBycityName(String cityName) {
        return new ResponseEntity<List<HotelNames>>(hotelNamesRepo.findByLocation(locationsRepo.findBycityNameLike(cityName).get(0)),HttpStatus.OK);

	}
   
	/*
	@Override
	public ResponseEntity<List<HotelCategoryResponse>> findByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
	
	@Override
	public HotelNames getJson(HotelNames hotelnames, MultipartFile file, long locId, long catId) throws IOException {
	      hotelnames.setImage(file.getBytes());
	      HotelCategory hotelCategory=hotelCategoryRepo.findById(catId).get();
	      Locations loc=this.locationRepository.findById(locId).get();
	     
	      hotelnames.setLocation(loc);
	      hotelnames.setHotelCategory(hotelCategory);
	   
	     
	  HotelNames name = this.hotelNamesRepo.save(hotelnames);
	  return name;
	    
	    }
*/
}
