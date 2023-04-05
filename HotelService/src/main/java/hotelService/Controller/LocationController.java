package hotelService.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hotelService.CustomException.RegistrationCustomException;
import hotelService.Enitity.Locations;
import hotelService.Repository.LocationsRepo;
import hotelService.Service.LocationService;

@CrossOrigin("*")
@RestController
public class LocationController {
	  @Autowired
	    private LocationsRepo locationsRepo;
	    
	  
	  @Autowired
	  
	  private LocationService locationService;
	    
	    @PostMapping("locations")
	      public ResponseEntity<Locations> saveLocations( @RequestBody Locations locations){
	    	 if (locationsRepo.existsByaddress(locations.getAddress())) {
				throw new RegistrationCustomException("707", "Address  Already Exists please enter unique");
	    	 }	 
	    	 else {
	          System.out.println("Save Locations>>>>>>>>>>>>>>>>>>>>>>");
	      return new ResponseEntity<>(locationsRepo.save( locations), HttpStatus.CREATED);
	}
	      }
	    
	    @DeleteMapping("/deleteLocationById/{id}")
	    
	 
	    public ResponseEntity<Map<String, Boolean>> deleteLocationById(@PathVariable Long id) {
	    	locationService.deleteLocationById(id);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);   
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
	    
	    @PutMapping("/updateLocation/{id}")
	    public ResponseEntity<Map<String, Boolean>>  updateLocations(@PathVariable Long id,  @RequestBody Locations locations) 
	    {
	    	locations.setId(id);
	    	locationService.updateLocations(locations);
           Map<String, Boolean> map = new HashMap<>();
   map.put("success", true);
         return new ResponseEntity<>(map, HttpStatus.CREATED);
}
	    
	    
	    @GetMapping("/getAllLocations")
	    public ResponseEntity<List<Locations>> allHotelNames(){
	    		List<Locations> allLocations= locationService.findAll();
	    		return new ResponseEntity<List<Locations>>(allLocations, HttpStatus.ACCEPTED);
	    	
	    }

	    @GetMapping("/getByLocationsId/{id}")
	    public ResponseEntity<Locations> getByLocationsId(@PathVariable Long id) {
	    	Locations locations = locationService.findById(id);
	        return new ResponseEntity<>(locations, HttpStatus.OK);
	    }
	    @GetMapping("/getByLocationsName/{cityName}")
        public List<Locations> getByLocationsName(@PathVariable String cityName) {
            List<Locations> locations = locationService.findByName(cityName);
            return locations;
        }
	    @GetMapping("/getByCityNameLetters/{cityName}")
        public List<Locations> finByCityNameLetters(@PathVariable String cityName) {
            List<Locations> locations = locationService.findBycityNameLike(cityName);
            return locations;
        }
	    }
