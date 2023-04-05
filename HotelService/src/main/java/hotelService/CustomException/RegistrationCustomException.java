package hotelService.CustomException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class RegistrationCustomException extends RuntimeException{
	
//	private String errorCode;
//	private String errorMessage;
	
	public RegistrationCustomException(String string,String message)
    {
        super(message);
    }
}
