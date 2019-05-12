package com.ecom.configuration;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfiguration {

	@Value("${product.name}")
	String name;

	@Value("${jdbc.driverClassName}")
	String driverClass;

	@Value("${jdbc.databaseurl}")
	String url;

	@Value("${jdbc.username}")
	String userName;

	@Value("${jdbc.password}")
	String password;

	@Bean
	Connection mysqlConnection() {
		Connection myconnection = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// myconnection = DriverManager.getConnection(url, userName, password);
			myconnection = mySqlDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return myconnection;
	}

	@Bean
	public DataSource mySqlDataSource() {
		// DriverManagerDataSource ds = new DriverManagerDataSource();
		org.apache.commons.dbcp.BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();

		ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		return ds;
	}

}
