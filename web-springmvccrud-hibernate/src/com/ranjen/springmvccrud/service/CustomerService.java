package com.ranjen.springmvccrud.service;

import java.util.List;

import com.ranjen.springmvccrud.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
}
