package se.ithuset.greenbean.lager;

public class NoSuchProductException extends Exception {
	
	/**
	 * hey ho, let's go!
	 */
	private static final long serialVersionUID = -5675491440524693051L;

	public NoSuchProductException(String msg) {
		super(msg);
	}
}
