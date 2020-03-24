package spring.util;

public class DuplicateMemberException extends RuntimeException {
	//
	private static final long serialVersionUID = -2895772541619493432L;
	
	public DuplicateMemberException(String message) {
		super(message);
	}
}
