package hotelService.Service;

import java.util.List;

import hotelService.Enitity.Locations;


public interface LocationService {
	
	public void updateLocations( Locations locations);
	
	public List<Locations> findAll();
	
	public  Locations findById(Long id);
	
	public void deleteLocationById(Long id);
	
	public List<Locations> findByName(String cityName);
	
	public List<Locations> findBycityNameLike(String cityName);

}
