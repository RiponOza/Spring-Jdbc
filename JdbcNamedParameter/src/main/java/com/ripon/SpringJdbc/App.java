package com.ripon.SpringJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ripon.spring.beans.Customer;
import com.ripon.spring.business.CustomerBusiness;
import com.ripon.spring.config.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	// customer bean object
    	Customer c = context.getBean(Customer.class);
    	c.setCustomerId(2003);
    	c.setCustomerName("Hakan");
    	
    	// business object
    	CustomerBusiness cb = context.getBean(CustomerBusiness.class);
    	cb.saveCustomer(c); // saving customer record
    	
    	//deleting customer record
    	cb.deleteCustomer(2001);
    }
}
