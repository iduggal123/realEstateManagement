package com.bits.af.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.af.entities.Booking;
import com.bits.af.entities.Customer;
import com.bits.af.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
