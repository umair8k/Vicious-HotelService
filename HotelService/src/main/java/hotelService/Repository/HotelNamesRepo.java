package hotelService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hotelService.Enitity.HotelNames;
import hotelService.Enitity.Locations;

public interface HotelNamesRepo extends JpaRepository<HotelNames, Long> {

	List<HotelNames> findByLocation(Locations locations);

	List<HotelNames> findByHotelCategory(HotelNames hotelNames);

}
