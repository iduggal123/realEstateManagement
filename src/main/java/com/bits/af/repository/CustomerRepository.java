package com.bits.af.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bits.af.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	boolean existsByclientEmailAddress(String clientEmailAddress);

	List<Customer> findByClientEmailAddress(@Param("clientEmailAddress") String email);
	
	List<Customer> findByClientId(@Param("clientId") int clientId);
	
}
