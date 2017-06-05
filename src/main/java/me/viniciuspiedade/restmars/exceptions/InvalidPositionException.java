package me.viniciuspiedade.restmars.exceptions;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = 2853982968686323045L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public InvalidPositionException() {
		super();
	}
	
	public InvalidPositionException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
