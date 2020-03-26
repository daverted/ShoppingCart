package com.prime.extra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.mockdata.generate.utils.RandomUtil;
import com.prime.shoppingcart.domain.Customer;
import com.prime.shoppingcart.domain.Order;
import com.prime.shoppingcart.manager.CustomerManager;
import com.prime.shoppingcart.manager.OrderManager;
import com.prime.shoppingcart.util.ExceptionListReader;

public class ShippingTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
    private boolean Ripe;  // Noncompliant
    private static String FLESH; // Noncompliant

	@SuppressWarnings("unchecked")
	public void processShipment(String customerNumber, String orderNumber, String shipmentDetails, String shipNumber) {	
		CustomerManager custManager = new CustomerManager();
		Customer customer = custManager.getCustomer(customerNumber);		
		log.info("Processing Shipment for {} ...", customer.getAccountNumber());
		
		OrderManager orderManager = new OrderManager();
		Order order = orderManager.getOrder(orderNumber, customerNumber);
		
		try {			
			int i = RandomUtil.getRandomNumberInRange(1, ExceptionListReader.getInstance().size() + 1);
			String className = (String) ExceptionListReader.getInstance().get(i + "");
			Class<Throwable> c = (Class<Throwable>) Class.forName(className);
			process(customer, order, shipmentDetails, shipNumber, c);
		}
		catch (Throwable e) {
			log.error("Error occured processing order", e);
		}
		log.info("Completed processing shipment {}", order.getOrderNumber());
	}
	
	private <T extends Throwable> void process(Customer customer, Order order, 
			String shipmentDetails, String shipNumber, Class<T> exceptionType) throws Exception, T {
		
	    String shippingMessage = "Exception while processing Order " + order.getOrderNumber();
	    log.debug("Customer is: {} ShipNumber is {}" + customer.getAccountNumber(), shipNumber);
	    throw exceptionType.getConstructor(String.class).newInstance(shippingMessage);
	}
	
    public int returnInteger(int a) {
        int b = 12;
        if (a == 1) {
           return b;
        }
    return b;
    }

   public int returnIntr(int a) {
        int b = 1000;
        if (a == 100) {
           return b;
        }
    return b;
    }
}