package hotelService.Service;

import java.util.List;



import hotelService.Enitity.Activities;



public interface ActivitiesService  {
	
	public List<Activities> findAll();

	 public void updateHotelNames( Activities activities);
	 
	 public Activities findById(Long id);
	 
	 public void deleteByActivitiesId(Long id);
}
