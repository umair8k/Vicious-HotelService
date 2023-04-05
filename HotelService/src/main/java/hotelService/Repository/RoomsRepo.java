package hotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotelService.Enitity.Rooms;

public interface RoomsRepo  extends JpaRepository<Rooms, Long>{

}
