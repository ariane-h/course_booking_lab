package com.example.codeclan.courseservice.repositories;

import com.example.codeclan.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by rating
    List<Course> findByRating(int rating);

    //find all courses for a given customer
    List<Course> findByBookingsCustomerName(String name);
}
