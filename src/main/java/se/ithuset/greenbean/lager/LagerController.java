package se.ithuset.greenbean.lager;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LagerController {
	
	private static final Logger logger = Logger.getLogger(LagerController.class);
	
	@Autowired @Qualifier("InMemoryStockRepository") StockRepository repo;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("stock", repo.getCompleteStockStatus());
		
		return "home";
	}
	
	@RequestMapping(value="/product/{productId}", method = RequestMethod.GET) 
	@ResponseBody
	public Product getProductInfo(@PathVariable String productId) throws NoSuchProductException {
		return repo.getStatus(productId);
	}
	
	@RequestMapping(value="/order/{orderId}", method = RequestMethod.POST) 
	@ResponseBody
	public Integer placeOrder(@RequestBody Order order, @PathVariable Integer orderId) throws NotEnoughItemsInStockException, NoSuchProductException {
		logger.info("Placing order " + order + " with id " + orderId);
		return repo.removeFromStock(order.getProductId(), order.getQty());
	}
	
	@RequestMapping(value="/order/{orderId}", method = RequestMethod.GET) 
	@ResponseBody
	public Order getOrder(@PathVariable Integer orderId) {
		return new Order();
	}
	
	@RequestMapping(value="/ping", method = RequestMethod.GET) 
	@ResponseBody
	public String getOrder() {
		return "pong";
	}
	
	
	@ExceptionHandler({NotEnoughItemsInStockException.class, NoSuchProductException.class})
	public @ResponseBody String handleExceptions(Exception e) {
		return e.getMessage();
	}
			
	
}
