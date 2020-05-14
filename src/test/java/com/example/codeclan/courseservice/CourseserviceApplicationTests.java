package com.example.codeclan.courseservice;

import com.example.codeclan.courseservice.models.Booking;
import com.example.codeclan.courseservice.models.Course;
import com.example.codeclan.courseservice.models.Customer;
import com.example.codeclan.courseservice.repositories.BookingRepository;
import com.example.codeclan.courseservice.repositories.CourseRepository;
import com.example.codeclan.courseservice.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseserviceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCustomersForACourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("Beginners Ju Jitsu");
	}

	@Test
	public void canGetCoursesForACustomer(){
		List<Course> foundCourses = courseRepository.findByBookingsCustomerName("Bjorn");
	}

	@Test
	public void canGetBookingsForADate(){
		List<Booking> foundBookings = bookingRepository.findByDate("01-01-2020");
	}



}
