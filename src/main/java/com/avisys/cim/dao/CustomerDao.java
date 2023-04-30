package com.avisys.cim.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avisys.cim.Customer;

public interface CustomerDao extends JpaRepository<Customer,Long>{

	Customer findByMobileNumber(String MobileNumber);
	
	@Query("Select DISTINCT c from Customer c where LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%'))")
	List<Customer> findByFirstName(@Param("firstName") String firstName);
	
	@Query("Select DISTINCT c from Customer c where LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%'))")
	List<Customer> findByLastsName(@Param("lastName") String lastName);
	
	@Query("Select DISTINCT c from Customer c where LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%')) AND LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%'))")
	List<Customer> findByFirstAndLastsName(@Param("firstName") String firstName ,@Param("lastName") String lastName);
   
	@Query("Select DISTINCT c from Customer c where LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%')) AND LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%')) AND c.mobileNumber = :mobileNumber")
	List<Customer> findByFirstAndLastsNameAndMobileNumber(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("mobileNumber") String mobileNumber);
   
	@Query("Select DISTINCT c from Customer c where LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%')) AND c.mobileNumber = :mobileNumber")
	List<Customer> findByFirstNameAndMobileNumber(@Param("firstName") String firstName, @Param("mobileNumber") String mobileNumber);
	
	@Query("Select DISTINCT c from Customer c where LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%')) AND c.mobileNumber = :mobileNumber")
	List<Customer> findByLastNameAndMobileNumber(@Param("lastName") String firstName, @Param("mobileNumber") String mobileNumber);

	
}
