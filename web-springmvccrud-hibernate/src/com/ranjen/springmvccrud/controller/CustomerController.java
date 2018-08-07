package com.ranjen.springmvccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		//bind the data from Customer object to customer-form.jsp
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	//to "saveCustomer" form action when submit the form in customer-form.jsp
	@PostMapping("/saveCustomer")
	//get the customer model attribute sent from customer-form.jsp
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		//redirect to customer list page
		return "redirect:/customer/list";
	}
	
	//to update customer
	@GetMapping("/showFormForUpdate")
	//request parameter coming in as customerId from list-customer.jsp, bind that to theId
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service based on the id
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	//to delete customer
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}

