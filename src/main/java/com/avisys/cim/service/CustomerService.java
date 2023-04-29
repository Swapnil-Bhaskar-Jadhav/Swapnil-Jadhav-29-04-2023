package com.avisys.cim.service;

import com.avisys.cim.Customer;

public interface CustomerService {

	
	Customer addCustomer(Customer customer);
	
	String customerDeleteByMobileNumber(String MobileNumber);
}
