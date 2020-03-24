package spring.util;

public class WrongIdPasswordException extends RuntimeException {
	//
	private static final long serialVersionUID = 4488101229851249528L;
	
	public WrongIdPasswordException(String message) {
		super(message);
	}
}
