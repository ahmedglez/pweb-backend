package cu.edu.cujae.pwebjsf.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeException(RuntimeException e) {
		return new ResponseEntity<>("[Exception Response] - Exception: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
