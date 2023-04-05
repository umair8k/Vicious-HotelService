package hotelService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hotelService.Enitity.Locations;

public interface LocationsRepo  extends JpaRepository<Locations,Long>{

	List<Locations> findAllBycityName(String cityName);

	List<Locations> findBycityNameLike(String cityName);

	boolean existsByaddress(String address);

}
