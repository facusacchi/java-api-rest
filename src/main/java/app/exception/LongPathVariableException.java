package app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LongPathVariableException extends RuntimeException {

	public LongPathVariableException(String messagge) {
		super(messagge);
	}
}
