package com.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.mockdata.generate.DelayGenerator;
import com.prime.mockdata.generate.utils.RandomUtil;
import com.prime.shoppingcart.domain.ShoppingCartProperties;
import com.prime.shoppingcart.manager.ShoppingCartPropertyManager;
import com.prime.shoppingcart.thirdpartyutils.URLConnectionHandler;

public class MainTesting {

	public final static Logger log = LoggerFactory.getLogger(MainTesting.class);
    private boolean Ripe;  // Noncompliant
    private static String FLESH; // Noncompliant
	
	public static void main(String[] args) {
		log.info("Starting Retail Application ...Waiting for 15 seconds for OverOps to Initialize");
		DelayGenerator.introduceDelay(15000);

		ShoppingCartProperties scProperties = ShoppingCartPropertyManager.populate(args);

		for (int i = 1; i <= 10; i++) {
//			ShoppingCartWF workflow = new ShoppingCartWF();
//			workflow.workflow14();
			
			String orderNumber = "ORD-" + RandomUtil.generateRandomNumericString(4);
			String customerNumber = "CUST-" + RandomUtil.generateRandomNumericString(4);
			
			log.info("CustomerNumber {}", customerNumber);
			log.info("OrderNumber {}", orderNumber);

			String connectString = scProperties.getUrlConnectString();
			
			URLConnectionHandler handler = new URLConnectionHandler();
			handler.handle(customerNumber, orderNumber, connectString);
		}

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
