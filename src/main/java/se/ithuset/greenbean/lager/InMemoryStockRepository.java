package se.ithuset.greenbean.lager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * Simple in-memory based stock repo.
 * 
 * 
 * @author svante
 */

@Component("InMemoryStockRepository")
public class InMemoryStockRepository implements StockRepository {
	
	private static final Map<String, Integer> inventory = new LinkedHashMap<String, Integer>();
	
	private static final Map<String, Integer> reOrderPoints = new LinkedHashMap<String, Integer>();
	
	private static final Map<String, String> productNames = new LinkedHashMap<String, String>();
	
	
	@PostConstruct public void init() {
		for(int i=1; i<6; i++) {
			inventory.put(i+"", new Random().nextInt(500));
			reOrderPoints.put(i+"", new Random().nextInt(50));
		}
		productNames.put("1", "Coffee: Robusta 1kg");
		productNames.put("2", "Coffee: Arabica Brazil 1kg");
		productNames.put("3", "Software: Roast automation system");
		productNames.put("4", "Roaster: Hot air roasting machine");
		productNames.put("5", "Roaster: Drum roasting machine");
	}

	/* (non-Javadoc)
	 * @see se.ithuset.greenbean.lager.Repository#getStatus(int)
	 */
	public Product getStatus(String productId) throws NoSuchProductException {
		if(inventory.get(productId) == null) {
			throw new NoSuchProductException("No product in stock with productId '" + productId + "'");
		}
		Product p = new Product();
		synchronized (inventory) {
			p.setItemsInStock(inventory.get(productId));
			p.setProductId(productId);
			p.setReOrderPoint(getReOrderPoint(productId));
			p.setName(productNames.get(productId));
		}
		return p;
	}

	/* (non-Javadoc)
	 * @see se.ithuset.greenbean.lager.Repository#removeFromStock(int, int)
	 */
	public int removeFromStock(String productId, int qty) throws NotEnoughItemsInStockException, NoSuchProductException {
		if(inventory.get(productId) == null) {
			throw new NoSuchProductException("No product in stock with productId '" + productId + "'");
		}
		
		synchronized (inventory) {
			int saldo = inventory.get(productId); 
			if(saldo < qty) {
				throw new NotEnoughItemsInStockException("Sorry, only " + inventory.get(productId) + " items in stock");
			}
			int newSaldo = saldo - qty;
			inventory.put(productId, newSaldo);
			return newSaldo;
		}
	}

	/* (non-Javadoc)
	 * @see se.ithuset.greenbean.lager.Repository#addToStock(int, int)
	 */
	public int addToStock(String productId, int qty) {
		synchronized (inventory) {
			if(inventory.containsKey(productId)) {
				return qty + inventory.put(productId, inventory.get(productId) + qty);
			}
			
			inventory.put(productId, qty);
			return qty;
		}
	}

	@Override
	public Map<String, Integer> getCompleteStockStatus() {
		return inventory;
	}

	@Override
	public int getReOrderPoint(String productId) throws NoSuchProductException {
		if(!reOrderPoints.containsKey(productId)) {
			throw new NoSuchProductException("No product in stock with productId '" + productId + "'");
		}
		return reOrderPoints.get(productId);
	}

}
