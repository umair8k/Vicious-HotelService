package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.Enitity.SourceName;
import hotelService.Repository.SourceNameRepo;


@Service
public class SourceNameServiceImpl  implements  SourceNameService{

	 @Autowired 
	 private  SourceNameRepo sourceNameRepo;
	
	@Override
	public List<SourceName> findAll() {
		return sourceNameRepo.findAll();
	}

}
