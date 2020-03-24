package spring.util;

public class MemberNotFoundException extends RuntimeException {
	//
	private static final long serialVersionUID = -3052694993096269346L;
	
	public MemberNotFoundException(String message) {
		super(message);
	}
}
