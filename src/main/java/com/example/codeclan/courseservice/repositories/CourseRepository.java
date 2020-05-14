package com.example.codeclan.courseservice.repositories;

import com.example.codeclan.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
