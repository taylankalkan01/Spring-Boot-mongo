package com.example.Studentmongo.config;

import com.example.Studentmongo.model.Address;
import com.example.Studentmongo.model.ClassYear;
import com.example.Studentmongo.model.Gender;
import com.example.Studentmongo.model.Student;
import com.example.Studentmongo.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class Runner implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public Runner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student("1",
                "first",
                "last",
                "demo@gmail.com",
                Gender.MALE,
                new Address("Turkey","Istanbul","34343"),
                "2001",
                ClassYear.SOPHOMORE,
                "Computer Science",
                LocalDateTime.now());
    }
}
