package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.Enitity.DestinationName;
import hotelService.Repository.DestinationNameRepo;


@Service 
public class DestinationNameServiceImpl implements DestinationNameService{

	
	@Autowired
	 private DestinationNameRepo destinationNameRepo; 
	
	@Override
	public List<DestinationName> findAll() {
		return destinationNameRepo.findAll();
	}

}
