package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.Enitity.Cab;
import hotelService.Repository.CabRepo;
 
@Service
public class CabServiceImpl implements CabService {

	 @Autowired
	 private CabRepo cabRepo;
	
	@Override
	public List<Cab> findAll() {
		return cabRepo.findAll();
	}

}
