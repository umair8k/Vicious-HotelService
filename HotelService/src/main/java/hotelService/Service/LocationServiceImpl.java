package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.Locations;
import hotelService.Repository.LocationsRepo;


@Service
public class LocationServiceImpl  implements LocationService{

	
	@Autowired
	private LocationsRepo locationsRepo; 

	@Override
	public void updateLocations(Locations locations)throws BadRequestException{
		try {
			locationsRepo.save(locations);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	}

	@Override
	public List<Locations> findAll() {
		return locationsRepo.findAll();
	}

	@Override
	public Locations findById(Long id) throws ResourceNotFoundException {
        return locationsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	@Override
	public void deleteLocationById(Long id) {
		locationsRepo.deleteById(id);
		
	}

	@Override
	public List<Locations> findByName(String cityName) {
		 return locationsRepo.findAllBycityName(cityName);
	}

	@Override
	public List<Locations> findBycityNameLike(String cityName) {
		 return locationsRepo.findBycityNameLike(cityName);
	}

}
