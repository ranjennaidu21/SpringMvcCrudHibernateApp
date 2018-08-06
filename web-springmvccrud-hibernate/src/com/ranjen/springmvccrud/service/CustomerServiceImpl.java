package com.ranjen.springmvccrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ranjen.springmvccrud.dao.CustomerDAO;
import com.ranjen.springmvccrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	//Put this transactional annotation in DAO class if service is not used.
	public List<Customer> getCustomers() {
		//delegate the call to DAO
		return customerDAO.getCustomers();
	}
}





