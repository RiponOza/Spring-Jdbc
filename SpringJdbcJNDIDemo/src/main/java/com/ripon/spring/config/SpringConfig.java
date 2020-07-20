package com.ripon.spring.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.ripon.spring.beans.Customer;



@Configuration
@ComponentScan(basePackages = "com.ripon.spring.*")
public class SpringConfig {
	

	@Bean
	public JndiObjectFactoryBean getDataSourceObject() {
		Properties props = new Properties(); // properties object creation and populating
		props.put("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
		props.put("java.naming.provider.url", "iiop://localhost:4848");
		
		JndiObjectFactoryBean jb = new JndiObjectFactoryBean();
		jb.setJndiName("Spring8AM"); //setting jndi name
		jb.setJndiEnvironment(props);//setting jndi environment
		return jb;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		// typecasting JndiObjectFactoryBean to Datasource
		DataSource ds = (DataSource)getDataSourceObject().getObject();//getObject() is a method of JndiObjectFactoryBean class
		
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(ds);// passing DataSource object
		return template;
	}
	
	@Bean("customer")
	@Scope("prototype")
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setCustomerId(0);
		c.setCustomerName("");
		return c;
	}
	

}
