package app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StringPathVariableException extends RuntimeException {
	
	public StringPathVariableException(String messagge) {
		super(messagge);
	}
}
