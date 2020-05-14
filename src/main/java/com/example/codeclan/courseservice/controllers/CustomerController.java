package com.example.codeclan.courseservice.controllers;

import com.example.codeclan.courseservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

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
}
