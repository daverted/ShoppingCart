package com.prime.shoppingcart.dao;

import com.prime.shoppingcart.domain.Product;

public interface ProductDAO {

	public abstract Product generate();
	public abstract Product generateProductWithSku();

	public abstract Product get(String productNumber);
	public abstract Product create(String productNumber);
	public abstract Product update(Product productNumber);
	public abstract boolean delete(Product productNumber);
}