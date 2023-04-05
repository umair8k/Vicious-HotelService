package hotelService.CustomException;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message, String string)
	{
		super(message);
	}

}
