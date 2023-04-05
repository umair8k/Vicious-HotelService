package hotelService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hotelService.Enitity.HotelCategory;
import hotelService.Enitity.HotelNames;

public interface HotelCategoryRepo extends JpaRepository<HotelCategory, Long> {

	List<HotelNames> findByCategoryName(String categoryName);

}
