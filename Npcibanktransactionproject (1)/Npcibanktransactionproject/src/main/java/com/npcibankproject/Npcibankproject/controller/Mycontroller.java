package com.npcibanktransactionproject.Npcibanktransactionproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npcibanktransactionproject.Npcibanktransactionproject.entity.Customer.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class Mycontroller {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl ;
	
	
	//***Customer Controller ***//
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		try {
			return ((Mycontroller) customerServiceImpl).getAllCustomer();
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}

		
	}
	
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) {
		try {
			return customerServiceImpl.getCustomer(Long.parseLong(customerId));
			
		}catch(Exception e) {
			System.out.println(e);
			Customer c = null;
			return c;
		}
		
	}
	@PostMapping
	public ResponseEntity addCustomer(@RequestBody Customer customer) {
		customerServiceImpl.addCustomer(customer) ;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch(Exception e) {
		System.out.println(e);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
}

@DeleteMapping("{customerId}")
public ResponseEntity<HttpStatus> deleteustomer(@PathVariable String customerId)) {
	try {
		customerServiceImpl.deleteCustomer(Long.parseLong(CustomerId));
		return new ResponseEntity<>.(HttpStaus.OK);
	}catch(Exception e) {
		System.out.println(e);
		return new ResponseEntity<>(HttpStatus.InTERNAL_SERVER_ERROR);
		
	}
	
 }
}


