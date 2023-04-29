package com.avisys.cim.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.dto.ErrorResponse;
import com.avisys.cim.dto.ResponseDTO;
import com.avisys.cim.service.CustomerService;
@RestController // It is a class level annotation which is combination of annotation
//@Controller and @ResponceBody -> used for marshalling
@RequestMapping("/customer")// This annotion is used to map request url with class method

public class CustomerController {
 @Autowired
 private CustomerService customerService;
 
 
 public CustomerController() {
		System.out.println("Inside ctor of"+getClass().getName());
	}

	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
	{
		// This Statement for just dubugging purpose
           System.out.println("in method of customerAdding");		
		try {
			// Invoking Service Layer Method For Saving Customer Details
			return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
		}catch(RuntimeException e){
			// If Incase Of Duplicate Mobile Number Error Occurs 
			return new ResponseEntity<>(new ErrorResponse("Customer Insertion Failed",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	// Functionality Provide Delete User By Mobile Number
	@DeleteMapping("/delete/{mobileNumber}")
	public ResponseEntity<?> customerDeleteByMobileNumber(@PathVariable String mobileNumber){
	
	try {
	 // Invoking customerService method to delete customer by mobile number
		return new ResponseEntity<>(new ResponseDTO(customerService.customerDeleteByMobileNumber(mobileNumber)),HttpStatus.OK);
	
	}catch(RuntimeException e) {
	// Incase mobile number is invalid control comes to this error handling branch and send error response
		return new ResponseEntity<>(new ErrorResponse("Mobile Number Doesnot exist",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

 
}
