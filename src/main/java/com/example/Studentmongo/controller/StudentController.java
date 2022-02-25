package com.example.Studentmongo.controller;

import com.example.Studentmongo.dto.CreateStudentRequest;
import com.example.Studentmongo.dto.StudentDto;
import com.example.Studentmongo.dto.UpdateStudentRequest;
import com.example.Studentmongo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") String id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return ResponseEntity.ok().body(studentService.saveStudent(createStudentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") String id){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") String id,
                                                        @RequestBody UpdateStudentRequest updateStudentRequest){
        return ResponseEntity.ok().body(studentService.updateStudentByID(id,updateStudentRequest));
    }

}
