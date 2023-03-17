package com.food.FoodSpringApp.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.FoodSpringApp.dao.CustomerDao;
import com.food.FoodSpringApp.dto.Customer;



@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;

	@PostMapping("/savecustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@GetMapping("/getcustomerbyemail/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		Optional<Customer> op= customerDao.getCustomerByEmail(email);
		if(op.isEmpty()) {
			return null;
		}else {
			return op.get();
		}
	}
	
	@GetMapping("/getcustomer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Optional<Customer> op=customerDao.getCustomerById(id);
		if(op.isEmpty()) {
			return null;
		}else {
			return op.get();
		}
	}
	
	@GetMapping("/customersdata")
	public List<Customer> getallCustomers() {
		return customerDao.getAllCustomer();
	}
	
	@PutMapping("/customerupdate")
	public Customer updateData(@RequestBody Customer customer) {
		return customerDao.updateCustomer(customer);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deletestudent(@PathVariable int  id) {
		Optional<Customer> op=customerDao.getCustomerById(id);
		
		if(op.isPresent()) {
			
			customerDao.deleteCustomer(id);
			return "Customer Data deleted" ;
			
		}else {
			return "Customer data Not Found";
		}

}}
