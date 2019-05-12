package com.ecom.service;

import java.util.List;

import com.ecom.model.Order;

public interface OrderService {
	
	public void saveOrder(Order c);
	
	public void deleteOrder(int OrderID);
	
	public void updateOrder(Order c);
	
	public List <Order> getAllOrders();
	
	public Order findbyName(String name);

}
