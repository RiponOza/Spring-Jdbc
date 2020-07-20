package com.ripon.spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ripon.spring.beans.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// setter for jdbc template object
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String insertCustomerRecord(Customer customer) {
		int insertStatus = jdbcTemplate.update("insert into customers values(?,?)", new Object[] {customer. getCustomerId(),customer.getCustomerName()});
		return (insertStatus > 0 ? "Secussfully inserted..." : "Error occured" );
	}

	public String deleteCustomerRecord(int customerId) {
		int deleteStatus = jdbcTemplate.update("delete from customers where ID=?", customerId);		
		return (deleteStatus>0 ? "Successfully deleted..." : "Error Occured....");
	}

	public String updateCustomerRecord(Customer customer) {
		
		return null;
	}

}
