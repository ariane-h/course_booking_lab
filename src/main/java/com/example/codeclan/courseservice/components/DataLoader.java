package com.example.codeclan.courseservice.components;

import com.example.codeclan.courseservice.models.Course;
import com.example.codeclan.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

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


    }

}
