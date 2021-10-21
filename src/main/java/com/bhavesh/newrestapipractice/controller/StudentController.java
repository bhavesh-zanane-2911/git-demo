package com.bhavesh.newrestapipractice.controller;

import com.bhavesh.newrestapipractice.exceptionHandler.exceptions.UserNotFoundException;
import com.bhavesh.newrestapipractice.model.Student;
import com.bhavesh.newrestapipractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public List<Student> allStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/students/byName")
    public List<Student> allStudentsByName(){
        return studentService.getAllStudentsSortByName();
    }

    @GetMapping(value = "/students/bySalaryDesc")
    public List<Student> allStudentsBySalaryDesc(){
        return studentService.getAllStudentsSortBySalaryDesc();
    }

    @GetMapping(value = "/students/byNameAndSalary")
    public List<Student> allStudentsByNameAndSalary(){
        return studentService.getAllStudentsSortByNameAndSalary();
    }

    @GetMapping(value = "/students/{id}")
    public Student findStudentById (@PathVariable int id) throws UserNotFoundException {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/students/{id}")
    public void deleteStuentById(@PathVariable int id)throws UserNotFoundException{
        studentService.deleteStudentById(id);
    }

    @PostMapping(path = "/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

}
