package com.prime.shoppingcart.dao;

import com.prime.shoppingcart.domain.Order;

public interface OrderDAO {

	public abstract Order get(String orderNumber);
	public abstract Order create(String orderNumber);
	public abstract Order update(Order order);
	public abstract boolean delete(Order order);
	public abstract void updateOrderDate(Order order, String orderDate);
}
