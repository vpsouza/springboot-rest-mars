package me.viniciuspiedade.restmars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(InvalidCommandException.class)
	public ResponseEntity<ErrorResponse> exceptionRestMarsHandler(InvalidCommandException ex) {
		logger.error("ProductException", ex);
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getErrorMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPositionException.class)
	public ResponseEntity<ErrorResponse> exceptionRestMarsHandler(InvalidPositionException ex) {
		logger.error("ProductException", ex);
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getErrorMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionRestMarsHandler(Exception ex) {
		logger.error("Exception", ex);
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
