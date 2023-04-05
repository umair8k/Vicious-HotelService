package hotelService.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hotelService.Enitity.HotelCategory;
import hotelService.Repository.HotelCategoryRepo;
import hotelService.Service.HotelCategoryService;



@RestController
public class HotelCategoryController {
	
	@Autowired
	private HotelCategoryRepo hotelCategoryRepo;
	
	@Autowired
	private HotelCategoryService hotelCategoryService;
	
	
	   @PostMapping("hotelCategory")
	      public ResponseEntity<HotelCategory> saveHotelCategory( @RequestBody HotelCategory hotelCategory)
	      {
	          System.out.println("Save hotelcategory>>>>>>>>>>>>>>>>>>>>>>");
	      return new ResponseEntity<>(hotelCategoryRepo.save(hotelCategory ), HttpStatus.CREATED);
	}
	    
	    @DeleteMapping("/deleteHotelCategoryById/{id}")
	   
	    public ResponseEntity<Map<String, Boolean>> deleteHotelCategory(@PathVariable Long id) {
	    	hotelCategoryService.deleteHotelCategory(id);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	        
	        
	    }
	    @GetMapping("/getAllHotelCategory")
	    public ResponseEntity<List<HotelCategory>> allHotelCategory(){
	    		List<HotelCategory> allHotelCategory= hotelCategoryService.findAll();
	    		return new ResponseEntity<List<HotelCategory>>(allHotelCategory, HttpStatus.ACCEPTED);
	    	
	    }


	     

	    @PutMapping("/updateHotelCategory/{id}")

	    public ResponseEntity<Map<String, Boolean>> updateHotelCategoryById(@PathVariable Long id,
	                                                             @RequestBody HotelCategory hotelCategory) {
	    	hotelCategory.setId(id);
	    	hotelCategoryService.updateHotelCategoryById(hotelCategory);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);
	        return new ResponseEntity<>(map, HttpStatus.CREATED);
	    }



	    @GetMapping("/getByHotelCategoryId/{id}")
	    public ResponseEntity<HotelCategory> getByHotelCategoryId(@PathVariable Long id) {
	    	HotelCategory hotelCategory = hotelCategoryService.findById(id);
	        return new ResponseEntity<>(hotelCategory, HttpStatus.OK);
	    }
	    

}







