package sait.frs.exception;

public class InvalidCitizenshipException extends Exception {
	public InvalidCitizenshipException() {
		super("Citizenship cannot be null");
	}
	
}
