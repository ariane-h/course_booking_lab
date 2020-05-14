package com.example.codeclan.courseservice.repositories;

import com.example.codeclan.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //get all customers for a given course
    List<Customer> findByBookingsCourseName(String name);
}
