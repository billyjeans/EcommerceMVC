package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ecom.configuration.HibernateConfiguration;
import com.ecom.model.Customer;
import com.ecom.model.Product;
import com.mysql.cj.jdbc.PreparedStatement;

@Component
public class CustomerDao {

	@Autowired
	Connection mysqlConnection;

	public void saveCustomerJDBC(Customer c) {
		
		PreparedStatement stmt = null;
		
		try {
			
			String sql = " insert into Customer (CustomerName, CustomerDob, CustomerEmail, CustomerContact, CustomerAddress) values (?,?,?,?,?)";
			
			stmt = (PreparedStatement) mysqlConnection.prepareStatement(sql);
			stmt.setString(2, c.getCustName());
			stmt.setDate(3, (Date) c.getCustDob());
			stmt.setString(4, c.getCustEmail());
			stmt.setString(5, c.getCustContact());
			stmt.setString(6, c.getCustAddress());
			stmt.execute(sql);
		} catch (SQLException e) {
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	public void saveCustomerHibernate(Customer c) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				HibernateConfiguration.class);
		SessionFactory factory = context.getBean("sessionFactoryBean", SessionFactory.class);
		Query query = (Query) factory.openSession().createQuery("from Product p");
		List<Product> list = ((org.hibernate.Query) query).list();
		System.out.println(list);

		

		factory.close();
		context.close();
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

}
