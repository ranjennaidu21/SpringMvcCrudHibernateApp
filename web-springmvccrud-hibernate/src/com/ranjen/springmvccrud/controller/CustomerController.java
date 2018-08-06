package com.ranjen.springmvccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.ranjen.springmvccrud.dao.CustomerDAO;
import com.ranjen.springmvccrud.entity.Customer;
import com.ranjen.springmvccrud.service.CustomerService;;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// no need to inject the customer dao as now we already added service layer.
/*	@Autowired
	private CustomerDAO customerDAO;*/
	
	//So now we need to inject the service layer in the controller.
	@Autowired
	private CustomerService customerService;
	//for all request type
	//@RequestMapping("/list")
	//for get mapping request
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// no more get customers from the dao, instead now we added service layer and 
		//delegate the call to it.
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}

