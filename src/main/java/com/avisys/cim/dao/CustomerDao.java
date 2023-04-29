package com.avisys.cim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisys.cim.Customer;

public interface CustomerDao extends JpaRepository<Customer,Long>{

	
}
