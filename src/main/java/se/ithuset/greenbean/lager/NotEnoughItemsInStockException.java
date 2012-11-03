package se.ithuset.greenbean.lager;

public class NotEnoughItemsInStockException extends Exception {
	
	/**
	 * ohh well...
	 */
	private static final long serialVersionUID = 4510980053343920294L;

	public NotEnoughItemsInStockException(String msg) {
		super(msg);
	}
}
