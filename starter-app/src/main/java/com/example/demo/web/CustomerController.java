package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public Iterable<Customer> getCustomerList() {
		return customerRepository.findAll();
	}
	
	@RequestMapping(value = "/findByName/{name}", method=RequestMethod.GET)
	public Iterable<Customer> getCustomerByName(@PathVariable String name) {
		return customerRepository.findByName(name);
	}

}
