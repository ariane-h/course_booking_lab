package com.example.codeclan.courseservice.components;

import com.example.codeclan.courseservice.models.Booking;
import com.example.codeclan.courseservice.models.Course;
import com.example.codeclan.courseservice.models.Customer;
import com.example.codeclan.courseservice.repositories.BookingRepository;
import com.example.codeclan.courseservice.repositories.CourseRepository;
import com.example.codeclan.courseservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        //courses
        Course course1 = new Course("Beginners Ju Jitsu","Edinburgh",4);
        courseRepository.save(course1);

        Course course2 = new Course("Advanced Krav Maga","Birmingham",3);
        courseRepository.save(course2);

        Course course3 = new Course("Intermediate Judo","Edinburgh",5);
        courseRepository.save(course3);

        Course course4 = new Course("Beginners Ju Jitsu","Glasgow",5);
        courseRepository.save(course4);

        Course course5 = new Course("Beginners Taekwondo","Glasgow",4);
        courseRepository.save(course5);

        //customers
        Customer customer1 = new Customer("John", "Edinburgh", 52);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jane", "Glasgow", 24);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Rachel", "Birmingham", 35);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Bjorn", "Edinburgh", 45);
        customerRepository.save(customer4);

        //bookings
        Booking booking1 = new Booking("10-04-2019",course1,customer4);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-01-2020", course5, customer2);
        bookingRepository.save(booking2);

    }

}
