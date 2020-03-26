package com.prime.shoppingcart.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.mockdata.generate.utils.RandomUtil;
import com.prime.shoppingcart.dao.ProductDAO;
import com.prime.shoppingcart.dao.impl.ProductDAOImpl;
import com.prime.shoppingcart.domain.Product;

public class ProductManager {

	private static final Logger log = LoggerFactory.getLogger(ProductManager.class);
	private ProductDAO productDAO = new ProductDAOImpl();
	private CustomEventManager customEventManager = new CustomEventManager();
	

	public Product get(String productNumber) {
		log.info("Getting the product with productNumber: {}", productNumber);
		return productDAO.get(productNumber);
	}

	public Product generate() {
		log.info("Generating a product");
		return productDAO.generate();
	}

	public Product generateProductWithSku() {
		log.info("Generating a product with a Sku");
		return productDAO.generateProductWithSku();
	}

	public double getVariablePrice(Product product) {
		log.info("Getting a variable price for product");
		PriceManager priceMgr = new PriceManager();
		Object priceObj = priceMgr.getVariablePrice(product);
		Double price = (Double) priceObj;
		log.info("Got a variable price: {}", price);
		return price.doubleValue();
	}

	public void update(Product product) {
		log.info("Updating the product: {}", product.getId());
		int randomNumber = RandomUtil.generateRandom(1000);
		if (randomNumber == 5) {
			customEventManager.generateEvent("Updating a product with productID: " + product.getProductNumber(), 
				"Updating a product with productNumber: " + product.getProductNumber());
		}
	}
}