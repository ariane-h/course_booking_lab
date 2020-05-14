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
            @RequestParam(name = "course", required = false) String courseName
    ){
        if(courseName != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }


        //default return all customers
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
