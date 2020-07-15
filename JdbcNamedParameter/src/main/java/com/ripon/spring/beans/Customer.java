package com.ripon.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private int CustomerId;
	private String CustomerName;
	
	// getters and setters
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	

}
