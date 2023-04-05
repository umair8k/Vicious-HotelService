package hotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hotelService.Enitity.DestinationName;
import hotelService.Repository.DestinationNameRepo;
import hotelService.Service.DestinationNameService;

@RestController
public class DestinationController {



   @Autowired
    private DestinationNameService destinationNameService;
    
    @Autowired
    private DestinationNameRepo destinationNameRepo;
    
     @PostMapping("/destinationname")
     public ResponseEntity<DestinationName> saveDestinationName( @RequestBody DestinationName destinationname)
     {
   
         System.out.println("Save destinationname>>>>>>>>>>>>>>>>>>>>>>");
         
         
     return new ResponseEntity<>(destinationNameRepo.save(destinationname), HttpStatus.CREATED);
}
     
     @GetMapping("/getAllDestinationName")
        public ResponseEntity<List<DestinationName>> allDestinationName(){
                List<DestinationName> allDestinationName = destinationNameService.findAll();
                return new ResponseEntity<List<DestinationName>>(allDestinationName, HttpStatus.ACCEPTED);
            
        }
}
