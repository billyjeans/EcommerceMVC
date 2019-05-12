package com.ecom.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecom.dao.CustomerDao;
import com.ecom.model.Customer;
import com.ecom.service.CustomerService;

@Component
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	public void saveCustomer(Customer c) {
		
		customerDao.saveCustomerJDBC(c);
		customerDao.saveCustomerHibernate(c);
	}
	
	public void deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		
	}

	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveCustomerJDBC(Customer c) {
		// TODO Auto-generated method stub
		
	}

	public void saveCustomerHibernate(Customer c) {
		// TODO Auto-generated method stub
		
	}
	
	

}
