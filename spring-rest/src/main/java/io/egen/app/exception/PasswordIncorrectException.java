package io.egen.app.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PasswordIncorrectException extends RuntimeException {


	private static final long serialVersionUID = 5603051271523964879L;

	public PasswordIncorrectException(String message) {
		super(message);
	}
}