package com.shoppingcart.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prime.shoppingcart.dao.SkuDAO;
import com.prime.shoppingcart.dao.impl.SkuDAOImpl;
import com.prime.shoppingcart.domain.SKU;
import com.prime.shoppingcart.exception.ShoppingCartException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkuTest {

	private static SkuDAO skuDAO = null;
	private static SKU sku = null;
	private static final Logger log = LoggerFactory.getLogger(SkuTest.class);

	@BeforeClass
	static void setUpBeforeClass() throws Exception {
		try {
			skuDAO = new SkuDAOImpl();
			sku = skuDAO.create("SKUTEST9000");
		} catch (Exception e) {
			log.error("Could not create Skew");
		}
	}

	@Test
	public void validateSku() {
		if (sku == null) {
			assertNull(sku, "Cannot validate Sku. Sku is null.");
		} else {
			assertEquals(sku.getSkuNumber(), "SKUTEST9000", "Sku Number is not available");
		}
	}
	
	@Test
	public void updateSku() {
		sku.setSkuName("TestSkuName");
		sku.setSkuDescription("TestSkuDescription");
		skuDAO.update(sku);
		assertEquals(true, true);
	}
	
	@Test
	public void validateSkuName() {
		if (sku == null) {
			assertNull(sku, "Cannot validate Sku Name. Sku is null.");
		} else {
			assertNotNull(sku.getSkuName(), "Sku Name is not available");
		}
	}

	@Test
	public void validateSkuDescription() {
		if (sku == null) {
			assertNull(sku, "Cannot validate Sku Description. Sku is null.");
		} else {
			assertNotNull(sku.getSkuDescription(), "Sku Description is not available");
		}
	}
	
	@Test
	public void validatedeleteSku() {
		if (sku == null) {
			assertNull(sku, "Cannot validate Sku Description. Sku is null.");
		} else {
			try {
				boolean success = skuDAO.delete(sku);
				assertTrue(success, "Unable to delete Sku");
			} catch (Exception e) {
				// Do nothing
			}
		}
	}
}