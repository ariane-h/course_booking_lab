package com.example.codeclan.courseservice.controllers;

import com.example.codeclan.courseservice.models.Customer;
import com.example.codeclan.courseservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //INDEX
    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomers(
            @RequestParam(name = "course", required = false) String courseName,
            @RequestParam(name = "town", required = false) String customerTown,
            @RequestParam(name="age", required = false) Integer customerAge
    ){
        if(customerAge != null && customerTown != null && courseName!= null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(customerAge, customerTown, courseName), HttpStatus.OK);
        }
        if(customerTown != null && courseName!= null){
            return new ResponseEntity(customerRepository.findByTownAndBookingsCourseName(customerTown, courseName), HttpStatus.OK);
        }

        if(courseName != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }

        //default return all customers
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getOneCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    //CREATE
    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id){
        if(customer.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
