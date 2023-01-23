package com.mainuddin.springbootrestapi.controller;

import com.mainuddin.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    using response entity below one
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Mainuddin","Rizvi");
        return ResponseEntity.ok()
                .header("custom-header","ramesh")
                .body(student);
    }

//    for reteiving list of object/bean
//    http://localhost:8080/students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Aman","Singhal"));
        students.add(new Student(3,"Suaib","Saifi"));
        students.add(new Student(4,"Harshit","Verma"));

        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    // spring boot RESTAPI with path variable
    // {id} URI Template variable
    // http://localhost:8080/students/1
    // you can do this http://localhost:8080/students/1/ramesh/verma
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId,firstName,lastName);
    }

//    springboot RESTAPI with request param
//    http://localhost:8080/students/query?id=1&firstName=Mainuddin&lastName=Rizvi

    @GetMapping("/students/query")
    public ResponseEntity<Student> getStudentRequestVariable(@RequestParam int id,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName){
        Student student = new Student(3,firstName,lastName);
        return ResponseEntity.ok(student);
    }

//    RESTAPI OF Post Mapping
    @PostMapping("/students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //deleting
    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int studentId){
        return ResponseEntity.ok("student deleted successfully");
    }

//    using without response entity below one

//
//    @GetMapping("/student")
//    public Student getStudent(){
//        Student student = new Student(1,"Mainuddin","Rizvi");
//        return student;
//    }
//
//    //    for reteiving list of object/bean
////    http://localhost:8080/students
//    @GetMapping("/students")
//    public List<Student> getStudents(){
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(2,"Aman","Singhal"));
//        students.add(new Student(3,"Suaib","Saifi"));
//        students.add(new Student(4,"Harshit","Verma"));
//
//        return students;
//    }
//
//    // spring boot RESTAPI with path variable
//    // {id} URI Template variable
//    // http://localhost:8080/students/1
//    // you can do this http://localhost:8080/students/1/ramesh/verma
//    @GetMapping("/students/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable("id") int studentId,
//                                       @PathVariable("first-name") String firstName,
//                                       @PathVariable("last-name") String lastName) {
//        return new Student(studentId,firstName,lastName);
//    }
//
////    springboot RESTAPI with request param
////    http://localhost:8080/students/query?id=1&firstName=Mainuddin&lastName=Rizvi
//
//    @GetMapping("/students/query")
//    public Student getStudentRequestVariable(@RequestParam int id,
//                                             @RequestParam String firstName,
//                                             @RequestParam String lastName){
//        return new Student(3,firstName,lastName);
//    }
//
//    //    RESTAPI OF Post Mapping
//    @PostMapping("/students/create")
//    @ResponseStatus(HttpStatus.CREATED)   //it will give 201 if you dont write than give 200 code
//    public Student createStudent(@RequestBody Student student){
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }
//
//    @PutMapping("/students/{id}/update")
//    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }
//
//    //deleting
//    @DeleteMapping("/students/{id}/delete")
//    public String updateStudent(@PathVariable("id") int studentId){
//        return "student deleted successfully";
//    }




}
