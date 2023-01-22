package com.mainuddin.springbootrestapi.controller;

import com.mainuddin.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Mainuddin","Rizvi");
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Aman","Singhal"));
        students.add(new Student(3,"Suaib","Saifi"));
        students.add(new Student(4,"Harshit","Verma"));

        return students;
    }
}