package sait.frs.exception;

public class NoMoreSeatsException extends Exception{
	public NoMoreSeatsException(){
		super("There are no more seats available on this Flight");
	}
}
