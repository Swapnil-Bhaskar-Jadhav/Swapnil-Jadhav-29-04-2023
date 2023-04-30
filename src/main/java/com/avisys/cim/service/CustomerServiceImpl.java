package com.avisys.cim.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.dao.CustomerDao;

import jakarta.transaction.Transactional;

@Service // This annotation spcifies follwing class contain some buisness logic
@Transactional // to specify automatic transaction management 
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
		// persistance object ref recieved
		customerDao.deleteById(CustomerId);

		return "Customer With Id :" + CustomerId + " Deleted Sucessfully";
		// State of object is detached
	}

	
	@Override
	public List<Customer> findByFirstName(String firstName) {
				
		
		return customerDao.findByFirstName(firstName);
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		
		return customerDao.findByLastsName(lastName);
	}

	@Override
	public List<Customer> findByFirstAndLastName(String firstName,String lastName) {
		
		return customerDao.findByFirstAndLastsName(firstName,lastName);
	}

	@Override
	public Customer findByMobileNumber(String mobileNumber) {
		
		return customerDao.findByMobileNumber(mobileNumber);
	}

	@Override
	public List<Customer> findByFirstAndLastNameAndMobileNumber(String firstName, String lastName,
			String mobileNumber) {
	
		return customerDao.findByFirstAndLastsNameAndMobileNumber(firstName, lastName,mobileNumber);
	}

	@Override
	public List<Customer> findByFirstNameAndMobileNumber(String firstName, String mobileNumber) {
		
		return  customerDao.findByFirstNameAndMobileNumber(firstName, mobileNumber);
	}

	@Override
	public List<Customer> findByLastNameAndMobileNumber(String lastName, String mobileNumber) {
		
		return customerDao.findByLastNameAndMobileNumber(lastName, mobileNumber);
	}

	@Override
	public List<Customer> findAllCustomer() {
		
		return customerDao.findAll();
	}

}
