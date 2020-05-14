package com.example.codeclan.courseservice.repositories;

import com.example.codeclan.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //get all customers for a given course
    List<Customer> findByBookingsCourseName(String name);

    //get all customers in a given town for a given course
    List<Customer> findByTownAndBookingsCourseName(String town, String courseName);

    //get all customers over a certain age in a given town for a given course
    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String courseName);
}
