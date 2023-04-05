package hotelService.Service;

import java.util.List;



import hotelService.Enitity.HotelCategory;



public interface HotelCategoryService {
	
	public List<HotelCategory> findAll();
	
	public void updateHotelCategoryById( HotelCategory hotelCategory);
	
	public HotelCategory findById(Long id);
	
	public void deleteHotelCategory(Long id);

}
