package com.example.Studentmongo.dto;

import com.example.Studentmongo.model.Address;
import com.example.Studentmongo.model.ClassYear;
import com.example.Studentmongo.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    private String dateOfBirth;
    private ClassYear classYear;
    private String bestSubjects;
}
