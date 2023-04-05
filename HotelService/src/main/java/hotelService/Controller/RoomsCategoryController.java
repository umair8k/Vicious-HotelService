package hotelService.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



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

import com.fasterxml.jackson.databind.ObjectMapper;

import hotelService.Enitity.RoomsCategory;
import hotelService.Repository.RoomsCategoryRepo;
import hotelService.Service.RoomsCategoryService;

@RestController
public class RoomsCategoryController {

	@Autowired
	private RoomsCategoryRepo roomsCategoryRepo;
	
	@Autowired
	
	private RoomsCategoryService roomsCategoryService;
	
	  
    @PostMapping("/addCategories")
      public ResponseEntity<RoomsCategory> saveRoomsCategory( @RequestBody RoomsCategory roomsCategory)
      {
 
          System.out.println("Save Locations>>>>>>>>>>>>>>>>>>>>>>");
      return new ResponseEntity<>(roomsCategoryRepo.save(roomsCategory ), HttpStatus.CREATED);
}
	
    
    @DeleteMapping("/deleteRoomCategoryById/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRoomCategoryById(@PathVariable Long id) {
    	roomsCategoryService.deleteRoomCategoryById(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    

    @GetMapping("/getAllRoomsCategory")
    public ResponseEntity<List<RoomsCategory>> allRoomsCategory(){
    		List<RoomsCategory> allRoomsCategory= roomsCategoryService.findAll();
    		return new ResponseEntity<List<RoomsCategory>>(allRoomsCategory, HttpStatus.ACCEPTED);
    	
    }

    @PutMapping("/updateRoomsCategory/{id}")

    public ResponseEntity<Map<String, Boolean>> updateRoomsCategory(@PathVariable Long id,
                                                             @RequestBody RoomsCategory roomsCategory) {
    	roomsCategory.setId(id);
    	roomsCategoryService.updateRoomsCategory(roomsCategory);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

   

    @GetMapping("/getByRoomsCategoryId/{id}")
    public ResponseEntity<RoomsCategory> getRoomsCategoryById(@PathVariable Long id) {
    	RoomsCategory roomsCategory = roomsCategoryService.findById(id);
        return new ResponseEntity<>(roomsCategory, HttpStatus.OK);
    }
    
    
  /*  
    
   @PostMapping("/upload RoomImage")
//    public ResponseEntity<?> uploadImage(@RequestParam ("image")MultipartFile file) throws IOException{
//    String uploadImage = roomCategoryService.uploadImage(file);
//    return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
//
//        }  

    @GetMapping(path="/getRoomImage")
     public ResponseEntity <byte[]> downloadImage(@RequestParam Long id){
     Optional<RoomsCategory> image=roomsCategoryService.downloadimage(id); 
     MediaType contentType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok()
          .contentType(contentType)
          .body(image.get().getImage());     
       }
    
     @PostMapping(value = "/AddRoomCategoryImage", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, 
             produces = {MediaType.APPLICATION_JSON_VALUE })
     public RoomsCategory postString(@RequestParam String roomcategory,
             @RequestParam (required = false)MultipartFile file)throws IOException
     {
       ObjectMapper objectMapper = new ObjectMapper();
             RoomsCategory rc = objectMapper.readValue(roomcategory,RoomsCategory.class);
             RoomsCategory rc1 = this.roomsCategoryService.getJson(rc,file);

  

             return rc1;

  

     }
     */
    
}
