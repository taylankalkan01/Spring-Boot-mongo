package com.example.Studentmongo.dto;

import com.example.Studentmongo.model.Address;
import com.example.Studentmongo.model.ClassYear;
import com.example.Studentmongo.model.Gender;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private String dateOfBirth;
    private ClassYear classYear;
    private String bestSubjects;
    private LocalDateTime created;
}
