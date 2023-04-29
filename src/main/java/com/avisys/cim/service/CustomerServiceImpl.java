package com.avisys.cim.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.dao.CustomerDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerDao.save(customer);
		
		
		
	}

	
	@Override
	public String customerDeleteByMobileNumber(String MobileNumber) {
		
		Long CustomerId = customerDao.findByMobileNumber(MobileNumber).getId();
		
		customerDao.deleteById(CustomerId);
		
		return "Customer With Id :"+CustomerId+" Deleted Sucessfully";
	}

}
