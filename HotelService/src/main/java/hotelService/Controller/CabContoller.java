
package hotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hotelService.Enitity.Cab;
import hotelService.Repository.CabRepo;
import hotelService.Repository.RoomDetailsRepo;
import hotelService.Service.CabService;

@RestController
public class CabContoller {

	@Autowired
	public CabService cabService;
	@Autowired
	public CabRepo cabRepo;
	@Autowired
	public RoomDetailsRepo roomDetailsRepo;

	@PostMapping("/cab")
	public ResponseEntity<Cab> savecab(@RequestBody Cab cab) {

		System.out.println("Save Rooms>>>>>>>>>>>>>>>>>>>>>>");

		return new ResponseEntity<>(cabRepo.save(cab), HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("/CabBooking") public ResponseEntity<?>
	 * saveCabBooking(@RequestBody CabBooking cabBooking, Authentication
	 * principal,RoomDetails roomDetails,RoomBooking roomBooking) {
	 * 
	 * String username=principal.getName(); UserRegistration
	 * user=this.userRepository.findByUsername(username);
	 * 
	 * cabBooking.setUserRegistration(user);
	 * 
	 * roomDetails =
	 * roomDetailsRepository.findById(cabBooking.getRoomDetails().getId()).get();
	 * 
	 * 
	 * 
	 * 
	 * roomBooking=roomBookingRepository.findByUserRegistration(user).get(0);
	 * 
	 * 
	 * Cab cab=cabRepository.findById(cabBooking.getCab().getId()).get();
	 * 
	 * if (roomDetails.isRoomStatus() == true ) {
	 * if((cabBooking.getBookingDate().isEqual(roomBooking.getCheckIn())||cabBooking
	 * .getBookingDate().isAfter(roomBooking.getCheckIn())) &&
	 * (cabBooking.getEndDate().isEqual(roomBooking.getCheckOut())||cabBooking.
	 * getEndDate().isBefore(roomBooking.getCheckOut())) &&
	 * (cabBooking.getBookingDate().isEqual(roomBooking.getCheckIn())||cabBooking.
	 * getBookingDate().isBefore(roomBooking.getCheckIn())) &&
	 * (cabBooking.getEndDate().isEqual(roomBooking.getCheckOut())||cabBooking.
	 * getEndDate().isAfter(roomBooking.getCheckOut())))
	 * 
	 * {
	 * 
	 * System.out.println("Save CabBooking>>>>>>>>>>>>>>>>>>>>>>");
	 * 
	 * Long day=
	 * ChronoUnit.DAYS.between(cabBooking.getBookingDate(),cabBooking.getEndDate());
	 * cabBooking.setTotal(cab.getPrice()*day); System.out.println("=========="+day+
	 * " Days ");
	 * 
	 * cabBookingRepository.save(cabBooking); return new
	 * ResponseEntity<>(cabBookingRepository.save(cabBooking), HttpStatus.CREATED);
	 * } } else { return new
	 * ResponseEntity<>("cannot book before room booking",HttpStatus.BAD_REQUEST); }
	 * return new
	 * ResponseEntity<>("cannot book after room booking",HttpStatus.BAD_REQUEST); }
	 * 
	 * /*
	 * 
	 * @PostMapping("/CabBooking") public ResponseEntity<?>
	 * saveCabBooking(@RequestBody CabBooking cabBooking, Principal principal,
	 * RoomDetails roomDetails) {
	 * 
	 * String username=principal.getName(); UserRegistration
	 * user=this.userRepository.findByUsername(username);
	 * cabBooking.setUserRegistration(user);
	 * 
	 * 
	 * 
	 * roomDetails =
	 * roomDetailsRepository.findById(cabBooking.getCab().getId()).get();
	 * 
	 * 
	 * 
	 * Cab cab=cabRepository.findById(cabBooking.getCab().getId()).get();
	 * 
	 * cabBooking.setCab(cab);
	 * 
	 * Double price = cab.getPrice(); if (roomDetails.isRoomStatus() == true) {
	 * System.out.println("Save CabBooking>>>>>>>>>>>>>>>>>>>>>>"); }
	 * 
	 * cabBooking.setBookingDate(cabBooking.getBookingDate());
	 * cabBooking.setEndDate(cabBooking.getEndDate()); Long day =
	 * ChronoUnit.DAYS.between(cabBooking.getBookingDate(),
	 * cabBooking.getEndDate()); cabBooking.setTotal(price*day);
	 * System.out.println("=========="+username);
	 * 
	 * roomDetails.setRoomStatus(true); cabBookingRepository.save(cabBooking);
	 * return new ResponseEntity<>(cabBookingRepository.save(cabBooking),
	 * HttpStatus.CREATED);
	 * 
	 * }
	 * 
	 */

	@GetMapping("/getAllCab")
	public ResponseEntity<List<Cab>> allCab() {
		List<Cab> allCab = cabService.findAll();
		return new ResponseEntity<List<Cab>>(allCab, HttpStatus.ACCEPTED);

	}

}
