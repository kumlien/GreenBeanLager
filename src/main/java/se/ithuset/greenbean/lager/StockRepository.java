package se.ithuset.greenbean.lager;

public interface StockRepository {
	
	/**
	 * Get the number of items in stock for the specified productId
	 * @param productId
	 */
	int getStatus(String productId) throws NoSuchProductException;
	
	/**
	 * 'Get' the specified number of items from the stock.
	 * 
	 * @param productId
	 * @param qty
	 * @return The number of items in stock after the removal
	 * @throws NotEnoughItemsInStockException
	 * @throws NoSuchProductException 
	 */
	int removeFromStock(String productId, int qty) throws NotEnoughItemsInStockException, NoSuchProductException;
	
	/**
	 * Add items to stock
	 * 
	 * @param productId
	 * @param qty
	 * @return The updated number of items in stock
	 */
	int addToStock(String productId, int qty) throws NoSuchProductException;
}
