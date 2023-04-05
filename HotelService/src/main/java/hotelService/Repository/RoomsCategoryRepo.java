package hotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotelService.Enitity.RoomsCategory;

public interface RoomsCategoryRepo  extends JpaRepository<RoomsCategory, Long>{

	Object findByroomType(String roomType);

}
