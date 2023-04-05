package hotelService.Enitity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Activities {
       @Id
       @GeneratedValue(generator = "act_seq", strategy = GenerationType.AUTO)
        private Long activityId;
        private String activityName;
        private Double price;
        
        @EqualsAndHashCode.Exclude
        @ToString.Exclude    
      
        @JsonIgnore
        @ManyToMany(mappedBy = "assignedActivities")
        private Set<HotelNames> hotelSet ;
}
