package com.bits.af.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.af.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
