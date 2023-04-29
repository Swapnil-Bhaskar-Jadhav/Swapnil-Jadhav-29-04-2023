package com.avisys.cim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.dto.ErrorResponse;
import com.avisys.cim.service.CustomerService;
@RestController
@RequestMapping("/customer")

public class CustomerController {
 @Autowired
 private CustomerService customerService;
 
 
 public CustomerController() {
		System.out.println("Inside ctor of"+getClass().getName());
	}

	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
	{
           System.out.println("in method of customerAdding");		
		try {
			return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
		}catch(RuntimeException e){
			return new ResponseEntity<>(new ErrorResponse("Customer Insertion Failed",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

 
}
