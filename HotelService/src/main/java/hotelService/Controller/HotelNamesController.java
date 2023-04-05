   package hotelService.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hotelService.Enitity.HotelNames;
import hotelService.Repository.HotelNamesRepo;
import hotelService.Repository.LocationsRepo;
import hotelService.Service.HotelNamesService;

@RestController

public class HotelNamesController {
	
	@Autowired
    private HotelNamesRepo hotelNamesRepo;
	
	@Autowired
	private HotelNamesService hotelNamesService;
	
	@Autowired
	private LocationsRepo locationRepo;
	   
	 
    
    
    @PostMapping("/saveHotel")
      public ResponseEntity<HotelNames> saveHotelNames( @RequestBody HotelNames hotelNames)
      {
          System.out.println("Save HotelNames>>>>>>>>>>>>>>>>>>>>>>");
          
         return new ResponseEntity<>(hotelNamesRepo.save( hotelNames), HttpStatus.CREATED);
}
    
    
    @DeleteMapping("/deleteByHotelNameId/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteByHotelNameId(@PathVariable Long id) {
    	hotelNamesService.deleteByHotelNameId(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    
    
	@GetMapping("/getAllHotelNames")
	public ResponseEntity<List<HotelNames>> allHotelNames() {
		List<HotelNames> allHotelNames = hotelNamesService.findAll();
		return new ResponseEntity<List<HotelNames>>(allHotelNames, HttpStatus.ACCEPTED);

	}

	@PutMapping("/updateHotelNames/{id}")

	public ResponseEntity<Map<String, Boolean>> updateHotelNames(@PathVariable Long id,
			@RequestBody HotelNames hotelNames) {
		hotelNames.setHotelId(id);
		hotelNamesService.updateHotelNames(hotelNames);
		Map<String, Boolean> map = new HashMap<>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/getByHotelNamesId/{id}")
	public ResponseEntity<HotelNames> getByHotelNamesId(@PathVariable Long id) {
		HotelNames hotelNames = hotelNamesService.findById(id);
		return new ResponseEntity<>(hotelNames, HttpStatus.OK);
	}

	@PutMapping("/{hotelId}/activity/{activityId}")
	public HotelNames assignActivityToHotel(@PathVariable Long hotelId, @PathVariable Long activityId) {
		return hotelNamesService.assignActivityToHotel(hotelId, activityId);
	}

  

	@GetMapping("/getHotelNamesByLocation/{cityName}")
	public ResponseEntity<List<HotelNames>> getHotelNamesByLocation(@PathVariable String cityName) {

		return hotelNamesService.findBycityName(cityName);

	}
	
	@GetMapping("/hotelNameByCategory/{categoryName}")

	public ResponseEntity<List<HotelNames>> getHotelNamesByResort(@PathVariable String categoryName) {
		return hotelNamesService.findByResort(categoryName);

	}
	/*
	@GetMapping("/getHotelNamesByCategory/{categoryName}")

	public ResponseEntity<List<HotelCategoryResponse>> getHotelNamesByCategory(@PathVariable String categoryName) {
		return hotelNamesService.findByCategory(categoryName);

	}
	
 

	@PostMapping(value = "/AddHotelImage", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public HotelNames postString(@RequestParam String hotelnames,
                                       @RequestParam (required = false) MultipartFile file,
                                       @RequestParam Long categoryId,
                                       @RequestParam Long locationId)throws IOException
                                     
      {
            ObjectMapper objectMapper = new ObjectMapper();
            HotelNames names=objectMapper.readValue(hotelnames,HotelNames.class);
            HotelNames hotel = this.hotelNamesService.getJson(names,file,categoryId,locationId); 

    return hotel;

    }

	@GetMapping(value = "/getHotelImages", produces = {
            MediaType.IMAGE_JPEG_VALUE})
    public byte[] gettString(@RequestParam Long hotelId)throws JsonMappingException, JsonProcessingException {


        byte[] encodeBase64 =  hotelNamesRepo.findById(hotelId).get().getImage();

     return encodeBase64;

    }
		
	
	
	
	*/
	

}
