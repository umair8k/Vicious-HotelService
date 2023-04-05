package hotelService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.CustomException.BadRequestException;
import hotelService.CustomException.ResourceNotFoundException;
import hotelService.Enitity.HotelCategory;
import hotelService.Repository.HotelCategoryRepo;


@Service
public class HotelCategoryServiceImpl implements HotelCategoryService {

	@Autowired
	
	private HotelCategoryRepo hotelCategoryRepo;
	
	@Override
	public List<HotelCategory> findAll() {
		return hotelCategoryRepo.findAll();
	}

	@Override
	public void updateHotelCategoryById(HotelCategory hotelCategory)throws BadRequestException{
		try {
			hotelCategoryRepo.save(hotelCategory);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        } 
		
		
	}

	@Override
	public HotelCategory findById(Long id) throws ResourceNotFoundException {
        return hotelCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }

	@Override
	public void deleteHotelCategory(Long id) {
		hotelCategoryRepo.deleteById(id);
		
	}

}
