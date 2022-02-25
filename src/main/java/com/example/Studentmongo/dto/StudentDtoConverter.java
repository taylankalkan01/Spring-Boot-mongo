package com.example.Studentmongo.dto;

import com.example.Studentmongo.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {

   public StudentDto converter(Student student){
       return StudentDto.builder()
                      .bestSubjects(student.getBestSubjects())
                      .classYear(student.getClassYear())
                      .dateOfBirth(student.getDateOfBirth())
                      .lastName(student.getLastName())
                      .created(student.getCreated())
                      .address(student.getAddress())
                      .id(student.getId())
                      .firstName(student.getFirstName())
                      .address(student.getAddress())
                      .email(student.getEmail())
               .build();
   }
}
