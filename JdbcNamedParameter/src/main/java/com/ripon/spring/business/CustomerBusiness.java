package com.ripon.spring.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripon.spring.Dao.CustomerDao;
import com.ripon.spring.beans.Customer;

@Service
public class CustomerBusiness {

	@Autowired
	private CustomerDao customerDao;
	
	// setter for customerDao
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void saveCustomer(Customer customer) {
		System.out.println("Customer Status ::: " + customerDao.insertCustomerRecord(customer));
	}
	
	public void deleteCustomer(int customerId) {
		System.out.println( customerDao.deleteCustomerRecord(customerId));
	}
}
