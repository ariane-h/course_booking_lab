package com.example.codeclan.courseservice.controllers;

import com.example.codeclan.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value ="/courses")
    public ResponseEntity getAllCourses(){

        //default return all courses
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

}
