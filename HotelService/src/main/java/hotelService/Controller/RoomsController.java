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


import hotelService.Enitity.Rooms;
import hotelService.Repository.RoomsRepo;
import hotelService.Service.RoomsService;

@RestController
@CrossOrigin("*")
public class RoomsController {  

	
	
	@Autowired
	private RoomsRepo roomsRepo;
	
	@Autowired
	private RoomsService roomsService;
	
	 @PostMapping("/saveRoom")
     public ResponseEntity<Rooms> saveRooms( @RequestBody Rooms rooms)
     {
   
         System.out.println("Save Rooms>>>>>>>>>>>>>>>>>>>>>>");
         
         
     return new ResponseEntity<>(roomsRepo.save( rooms), HttpStatus.CREATED);
}
	 @DeleteMapping("/deleteByRoomsId/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteByRoomsId(@PathVariable Long id) {
		 roomsService.deleteByRoomsId(id);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
	      
	    

	@GetMapping("/getAllRooms")
	public ResponseEntity<List<Rooms>> allRooms(){
			List<Rooms> allRooms= roomsService.findAll();
			return new ResponseEntity<List<Rooms>>(allRooms, HttpStatus.ACCEPTED);
		
	}


	 

	@PutMapping("/updateRooms/{id}")

	public ResponseEntity<Map<String, Boolean>> updateRooms(@PathVariable Long id,
	                                                         @RequestBody Rooms rooms) {
		rooms.setId(id);
		roomsService.updateRooms(rooms);
	    Map<String, Boolean> map = new HashMap<>();
	    map.put("success", true);
	    return new ResponseEntity<>(map, HttpStatus.CREATED);
	}



	@GetMapping("/getByRoomsId/{id}")
	public ResponseEntity<Rooms> getByRoomsId(@PathVariable Long id) {
		Rooms rooms = roomsService.findById(id);
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
}

