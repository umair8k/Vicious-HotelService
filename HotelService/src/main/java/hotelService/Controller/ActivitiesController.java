package hotelService.Controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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

import hotelService.Enitity.Activities;
import hotelService.Repository.ActivitiesRepo;
import hotelService.Service.ActivitiesService;




@RestController
public class ActivitiesController {
	
	@Autowired
    ActivitiesRepo activitiesRepo;
	
	@Autowired
	ActivitiesService activitiesService;
	
		
	  @PostMapping("/saveActivities")
	  
      public ResponseEntity<Activities> saveActivities( @RequestBody Activities activities)
                              {
                  System.out.println("Save Activities>>>>>>>>>>>>>>>>>>>>>>");
           
                  return new ResponseEntity<>(activitiesRepo.save( activities), HttpStatus.CREATED);
                               }
    
    
    @DeleteMapping("/deleteByActivitiesId/{id}")
    
    public ResponseEntity<Map<String, Boolean>> deleteByActivitiesId(@PathVariable Long id)
                               {
    	                   activitiesService.deleteByActivitiesId(id);
                           Map<String, Boolean> map = new HashMap<>();
                           map.put("success", true);
                           return new ResponseEntity<>(map, HttpStatus.OK);
                                }
    
    
    

        @GetMapping("/getAllActivities")
           
         public ResponseEntity<List<Activities>> allActivities()
                    {
		          List<Activities> allActivities=activitiesService.findAll();
		          return new ResponseEntity<List<Activities>>(allActivities, HttpStatus.ACCEPTED);
	
                    }

        @PutMapping("/updateActivities/{id}")

       public ResponseEntity<Map<String, Boolean>> updateActivities(@PathVariable Long id,
                                                       @RequestBody Activities activities) 
                         {
	                    activities.setActivityId(id);
	                    activitiesService.updateHotelNames(activities);
                        Map<String, Boolean> map = new HashMap<>();
                        map.put("success", true);
                        return new ResponseEntity<>(map, HttpStatus.CREATED);
                         }

      @GetMapping("/getByActivitiesId/{id}")
      
           public ResponseEntity<Activities> getByActivitiesId(@PathVariable Long id)
                      {
	             Activities activities = activitiesService.findById(id);
                 return new ResponseEntity<>(activities, HttpStatus.OK);
                      }
	
}
