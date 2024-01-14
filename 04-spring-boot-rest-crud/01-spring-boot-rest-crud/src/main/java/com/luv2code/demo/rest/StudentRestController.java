package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private  List<Student> theStudents;

    // define @PostConstruct to load the student data .. only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Suyash","Mishra"));
        theStudents.add(new Student("Aman","Pandey"));
        theStudents.add(new Student("John","Doe"));
    }

    // define endpoint for "/students' -> return a list of students
    @GetMapping("/students")
    public List<Student> getStudent(){
        return theStudents;
    }

    // define endpoint for "/student/{studentId}"
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if((studentId < 0) || (studentId >= theStudents.size())){
            throw  new StudentNotFoundException("Student id not Found - " + studentId);
        }
        return theStudents.get(studentId);
    }
  }
