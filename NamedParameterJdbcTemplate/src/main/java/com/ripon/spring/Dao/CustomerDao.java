package com.ripon.spring.Dao;

import com.ripon.spring.beans.Customer;

public interface CustomerDao {
	
	// insert data into database
	public String insertCustomerRecord(Customer customer);
	
	// delete record from database
	public String deleteCustomerRecord(int customerId);
	
	// update record
	public String updateCustomerRecord(Customer customer);
	 

}
