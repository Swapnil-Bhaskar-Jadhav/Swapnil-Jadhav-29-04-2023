package com.avisys.cim.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.dto.ErrorResponse;
import com.avisys.cim.dto.ResponseDTO;
import com.avisys.cim.service.CustomerService;

@RestController // It is a class level annotation which is combination of annotation
//@Controller and @ResponceBody -> used for marshalling
@RequestMapping("/customer") // This annotion is used to map request url with class method

public class CustomerController {
	@Autowired
	private CustomerService customerService;

	public CustomerController() {
		System.out.println("Inside ctor of" + getClass().getName());
	}

	// Functionality To Create New User So Additng Transient Entity
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		// This Statement for just dubugging purpose
		System.out.println("in method of customerAdding");
		try {
			// Invoking Service Layer Method For Saving Customer Details
			return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			// If Incase Of Duplicate Mobile Number Error Occurs
			return new ResponseEntity<>(new ErrorResponse("Customer Insertion Failed", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	

	// Functionality Provide Delete User By Mobile Number
	@DeleteMapping("/delete/{mobileNumber}")
	public ResponseEntity<?> customerDeleteByMobileNumber(@PathVariable String mobileNumber) {

		try {
			// Invoking customerService method to delete customer by mobile number
			return new ResponseEntity<>(new ResponseDTO(customerService.customerDeleteByMobileNumber(mobileNumber)),
					HttpStatus.OK);

		} catch (RuntimeException e) {
			// Incase mobile number is invalid control comes to this error handling branch
			// and send error response
			return new ResponseEntity<>(new ErrorResponse("Mobile Number Doesnot exist", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	// This Method Provide Functionality Of Finding Customer On Different Parameter
	@GetMapping("/find")
	public ResponseEntity<?> findCustomerWithDifferentParamerter(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) String mobileNumber) {
		try {

			if (firstName != null && lastName != null && mobileNumber != null) {

				// Invoking Service Method To Find Customer On The Basis Of firstName And
				// LastName And MobileNumber
				return new ResponseEntity<>(
						customerService.findByFirstAndLastNameAndMobileNumber(firstName, lastName, mobileNumber),
						HttpStatus.OK);
			}

			else if (firstName != null && lastName != null) {
				// Invoking Service Method To Find Customer On The Basis Of firstName And
				// LastName
				return new ResponseEntity<>(customerService.findByFirstAndLastName(firstName, lastName), HttpStatus.OK);

			} else if (firstName != null && mobileNumber != null) {
				// Invoking Service Method To Find Customer On The Basis Of firstName And
				// MobileNumber
				return new ResponseEntity<>(customerService.findByFirstNameAndMobileNumber(firstName, mobileNumber),
						HttpStatus.OK);
			} else if (lastName != null && mobileNumber != null) {

				// Invoking Service Method To Find Customer On The Basis Of LastName And
				// MobileNumber
				return new ResponseEntity<>(customerService.findByLastNameAndMobileNumber(lastName, mobileNumber),
						HttpStatus.OK);
			}

			else if (firstName != null) {

				// Invoking Service Method To Find Customer On The Basis Of firstName
				return new ResponseEntity<>(customerService.findByFirstName(firstName), HttpStatus.OK);

			} else if (lastName != null) {

				// Invoking Service Method To Find Customer On The Basis Of LastName
				return new ResponseEntity<>(customerService.findByLastName(lastName), HttpStatus.OK);

			} else if (mobileNumber != null) {

				// Invoking Service Method To Find Customer On The Basis Of MobileNumber
				return new ResponseEntity<>(customerService.findByMobileNumber(mobileNumber), HttpStatus.OK);
			} else {
				// Invoking Service Method To Find Customers
				return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			return new ResponseEntity<>("Customer Not Found . Invalid Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	// Provide Functionality Of Update User Mobile Number
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> UpdateMobileNumberOfExistingCustomer(@PathVariable Long id,@RequestParam String mobileNumber){
	          //Invoking Service Method To Find Customer Whose Mobile Number Is To Be Updated
			 Customer c  = customerService.findCustomer(id,mobileNumber);
			 if(c!=null)
			    return new ResponseEntity<>(c,HttpStatus.OK );
			 else 
			    return new ResponseEntity<>(new ErrorResponse("Customer not found",""),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	

}
