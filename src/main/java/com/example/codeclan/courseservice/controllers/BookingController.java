package com.example.codeclan.courseservice.controllers;

import com.example.codeclan.courseservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity getAllBookings(
            @RequestParam(name="date", required = false) String date
    ){
        if( date!= null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        //default return all bookings
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }
}
