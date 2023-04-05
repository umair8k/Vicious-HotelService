package hotelService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hotelService.Enitity.RoomDetails;

public interface RoomDetailsRepo extends JpaRepository<RoomDetails, Long> {

	List<RoomDetails> findByRoomsCategory(Object findByroomType);

}
