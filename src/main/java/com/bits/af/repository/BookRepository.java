package com.bits.af.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.af.entities.Booking;

@Repository
public interface BookRepository extends JpaRepository<Booking, Integer> {

}
