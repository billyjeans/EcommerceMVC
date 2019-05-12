package com.ecom.configuration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:spring/application.properties")
@EnableTransactionManagement
@ComponentScan("com.ecom.model")
public class HibernateConfiguration {
	
	@Value("${jdbc.databaseurl}")
	String url;

	@Value("${jdbc.username}")
	String userName;

	@Value("${jdbc.password}")
	String password;
	
	@Value("${jdbc.driverClassName}")
	String driverClass;

	@Bean(destroyMethod = "close")
	public DataSource mySqlDataSource() {
		// DriverManagerDataSource ds = new DriverManagerDataSource();
		org.apache.commons.dbcp.BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		return ds;
	}
	
	
	
	/*
	 * @Bean public AnnotationSessionFactoryBean sessionFactoryBean() { Properties
	 * props = new Properties(); props.put("hibernate.dialect",
	 * MySQLDialect.class.getName()); props.put("hibernate.format_sql", "true");
	 * props.put("hibernate.show_sql", "true");
	 * 
	 * AnnotationSessionFactoryBean bean = new AnnotationSessionFactoryBean();
	 * //bean.setAnnotatedClasses(new Class[]{Item.class, Order.class});
	 * bean.setPackagesToScan(new String[] {"com.mhussain.entity"});
	 * bean.setHibernateProperties(props); bean.setDataSource(mySqlDataSource());
	 * bean.setSchemaUpdate(true); //bean.setCacheRegionFactory(cacheRegionFactory);
	 * return bean; }
	 */
	@Bean
	public SessionFactory sessionFactoryBean() throws IOException {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQLDialect.class.getName());
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.pool_size",1);
		props.put(AvailableSettings.HBM2DDL_AUTO,"update");

		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		//bean.setAnnotatedClasses(new Class[]{Item.class, Order.class});	
		bean.setPackagesToScan(new String[] {"com.mhussain.entity"});
		
		bean.setHibernateProperties(props);
		bean.setDataSource(mySqlDataSource());
		bean.afterPropertiesSet();
		return bean.getObject();
	}
	/*
	 * @Bean CacheRegionFactory cacheRegionFactory() {
	 * 
	 * }
	 */

	@Bean
	public HibernateTransactionManager transactionManager() throws Exception {
		return new HibernateTransactionManager(sessionFactoryBean());
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
