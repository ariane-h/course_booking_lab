package com.example.codeclan.courseservice.repositories;

import com.example.codeclan.courseservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //All bookings for a given date
    List<Booking> findByDate(String date);
}
