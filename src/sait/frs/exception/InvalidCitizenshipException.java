package sait.frs.exception;

public class InvalidCitizenshipException extends Exception {
	public InvalidCitizenshipException() {
		super("Citezenship cannot be null");
	}
	
}
