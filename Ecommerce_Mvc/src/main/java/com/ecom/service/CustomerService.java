package com.ecom.service;

import java.util.List;

import com.ecom.model.Customer;

public interface CustomerService {
	
	public void saveCustomerJDBC(Customer c);
	public void saveCustomerHibernate(Customer c);
	
	public void deleteCustomer(int customerID);
	
	public void updateCustomer(Customer c);
	
	public List <Customer> getAllCustomers();
	
	public Customer findbyName(String name);

}
