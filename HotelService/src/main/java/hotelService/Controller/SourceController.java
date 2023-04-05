package hotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hotelService.Enitity.SourceName;
import hotelService.Repository.SourceNameRepo;
import hotelService.Service.SourceNameService;

@RestController
public class SourceController {



   @Autowired
    private SourceNameService sourceNameService;
    
    @Autowired
    private SourceNameRepo sourceNameRepo;
    
     @PostMapping("/sourcename")
     public ResponseEntity<SourceName> savesourcename( @RequestBody SourceName sourcename)
     {
   
         System.out.println("Save sourcename>>>>>>>>>>>>>>>>>>>>>>");
         
         
     return new ResponseEntity<>(sourceNameRepo.save(sourcename), HttpStatus.CREATED);
}
     
     @GetMapping("/getAllSourceName")
        public ResponseEntity<List<SourceName>> allSourceName(){
                List<SourceName> allSourceName = sourceNameService.findAll();
                return new ResponseEntity<List<SourceName>>(allSourceName, HttpStatus.ACCEPTED);
            
        }
}