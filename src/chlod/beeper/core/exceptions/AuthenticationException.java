package chlod.beeper.core.exceptions;

public class AuthenticationException extends Exception {

	private static final long serialVersionUID = -8225977008124810018L;
	private String Message;
	
	public AuthenticationException(String message) {
		Message = message;
	}
	
	
	@Override
	public void printStackTrace() {
		System.out.println(Message);
		super.printStackTrace();
	}

}
