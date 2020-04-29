package com.prime.shoppingcart.dao;

import com.prime.shoppingcart.domain.SKU;

public interface SkuDAO {

	public abstract SKU generate();
	public abstract SKU get(String skuNumber);
	public abstract SKU create2(String skuNumber);
	public abstract SKU update(SKU sku);
	public abstract boolean delete(SKU sku);
}