package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.Customer;

public interface CustomerService {

	
	Customer addCustomer(Customer customer);
	
	String customerDeleteByMobileNumber(String MobileNumber);
	
	List<Customer> findByFirstName(String firstName);
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstAndLastName(String firstName,String lastName);

	Customer findByMobileNumber(String mobileNumber);

	List<Customer> findByFirstAndLastNameAndMobileNumber(String firstName, String lastName, String mobileNumber);

	List<Customer> findByFirstNameAndMobileNumber(String firstName, String mobileNumber);
	
	List<Customer> findByLastNameAndMobileNumber(String lastName, String mobileNumber);

	List<Customer> findAllCustomer();
}
