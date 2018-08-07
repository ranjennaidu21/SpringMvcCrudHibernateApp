package com.ranjen.springmvccrud.dao;

import java.util.List;

import com.ranjen.springmvccrud.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
