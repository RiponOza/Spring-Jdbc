package com.ripon.spring.Dao;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ripon.spring.beans.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	private String sqlquery = "insert into customers values(:customerId, :customerName)";

	public String insertCustomerRecord(Customer customer) {
		/*
		 SqlParameterSource parameter = new BeanPropertySqlParameterSource(customer);
		 */
		
		/*
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("customerId", customer.getCustomerId());
		params.put("customerName", customer.getCustomerName());
		*/
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("customerId", customer.getCustomerId());
		params.addValue("customerName", customer.getCustomerName());
		
		int status = npjt.update(sqlquery, params);
		return (status > 0 ? "Data inserted.." : "Error occured...");
	}

	public String deleteCustomerRecord(int customerId) {
		return null;
	}

	public String updateCustomerRecord(Customer customer) {

		return null;
	}

}
