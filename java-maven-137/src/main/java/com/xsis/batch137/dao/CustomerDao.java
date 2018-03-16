package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Customer;

public interface CustomerDao {

	void save(Customer customer);

	List<Customer> selectAll();

	Customer getCustomerById(String id);

}
