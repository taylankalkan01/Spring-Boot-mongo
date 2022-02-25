package com.example.Studentmongo.service;

import com.example.Studentmongo.dto.CreateStudentRequest;
import com.example.Studentmongo.dto.StudentDto;
import com.example.Studentmongo.dto.StudentDtoConverter;
import com.example.Studentmongo.dto.UpdateStudentRequest;
import com.example.Studentmongo.exception.StudentNotFoundException;
import com.example.Studentmongo.model.Student;
import com.example.Studentmongo.repos.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;

    public StudentService(StudentRepository studentRepository, StudentDtoConverter studentDtoConverter) {
        this.studentRepository = studentRepository;
        this.studentDtoConverter = studentDtoConverter;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                       .stream().map(studentDtoConverter::converter).collect(Collectors.toList());
    }

    public StudentDto getStudentById(String id){
        return studentRepository.findById(id).map(studentDtoConverter::converter).orElse(new StudentDto());
    }

    public StudentDto saveStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setId(createStudentRequest.getId());
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setGender(createStudentRequest.getGender());
        student.setAddress(createStudentRequest.getAddress());
        student.setDateOfBirth(createStudentRequest.getDateOfBirth());
        student.setClassYear(createStudentRequest.getClassYear());
        student.setBestSubjects(createStudentRequest.getBestSubjects());
        student.setCreated(createStudentRequest.getCreated());

        studentRepository.save(student);
        return studentDtoConverter.converter(student);


    }

    public void deleteStudent(String id){
        studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found!"));
        studentRepository.deleteById(id);
    }

    public StudentDto updateStudentByID(String id, UpdateStudentRequest updateStudentRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        optionalStudent.ifPresent(student -> {
            student.setFirstName(updateStudentRequest.getFirstName());
            student.setLastName(updateStudentRequest.getLastName());
            student.setGender(updateStudentRequest.getGender());
            student.setAddress(updateStudentRequest.getAddress());
            student.setDateOfBirth(updateStudentRequest.getDateOfBirth());
            student.setClassYear(updateStudentRequest.getClassYear());
            student.setBestSubjects(updateStudentRequest.getBestSubjects());

            studentRepository.save(student);
        });
        return optionalStudent.map(studentDtoConverter::converter).orElse(new StudentDto());
    }
}
