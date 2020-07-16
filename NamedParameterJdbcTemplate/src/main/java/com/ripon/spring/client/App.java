package com.ripon.spring.client;

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
        //ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
    	
        // bean object creation
        Customer customer = context.getBean(Customer.class);
        customer.setCustomerId(2012);
        customer.setCustomerName("LLLL");
        
        // business object creation
        CustomerBusiness cb = context.getBean(CustomerBusiness.class);
        cb.saveCustomer(customer);
    
    }
    
    
}








