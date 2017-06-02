package me.viniciuspiedade.restmars.exceptions;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 6596725401914659454L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public InvalidCommandException() {
		super();
	}
	
	public InvalidCommandException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
