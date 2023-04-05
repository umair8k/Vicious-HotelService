package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.Activities;
import hotelService.Repository.ActivitiesRepo;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
 
	@Autowired
	 private ActivitiesRepo activitiesRepo;
	
	
	
	@Override
	public List<Activities> findAll() {
		return activitiesRepo.findAll();
	}

	@Override
	public void updateHotelNames(Activities activities)throws BadRequestException{
        try 
        {
        	activitiesRepo.save(activities);
        }
        catch (Exception e)           
        {
    throw new BadRequestException("invalid request"); 
    
	}
	}
	
	@Override
	public Activities findById(Long id)throws ResourceNotFoundException 
    {
 return activitiesRepo.findById(id)
     .orElseThrow(() -> new ResourceNotFoundException("709","resource not found")); 
 }


	@Override
	public void deleteByActivitiesId(Long id) {
		activitiesRepo.deleteById(id);
	}

}
