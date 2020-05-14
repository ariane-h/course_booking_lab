package com.example.codeclan.courseservice.controllers;

import com.example.codeclan.courseservice.repositories.CourseRepository;
import com.sun.xml.internal.ws.client.ResponseContextReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value ="/courses")
    public ResponseEntity getAllCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="customer", required = false) String customerName
    ){
        if( rating != null){
            return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if( customerName != null){
            return new ResponseEntity(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        }

        //default return all courses
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

}
