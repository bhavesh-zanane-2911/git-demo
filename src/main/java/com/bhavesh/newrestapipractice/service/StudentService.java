package com.bhavesh.newrestapipractice.service;

import com.bhavesh.newrestapipractice.exceptionHandler.exceptions.UserNotFoundException;
import com.bhavesh.newrestapipractice.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentService {
    static List<Student> students=new ArrayList<>();
    static{
        students.add(new Student(1,"Adesh","Pune",1000));
        students.add(new Student(2,"Bhavesh","Hadapsar",5000));
        students.add(new Student(3,"Bhavesh","Baramati",4000));
        students.add(new Student(4,"Seema","Nashik",3000));
        students.add(new Student(5,"Shivani","Hinjewadi",6000));

    }

    public List<Student> getAllStudent(){
        return students;

    }

    public List<Student>getAllStudentsSortByName(){
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudentsSortBySalaryDesc(){
        return students.stream()
                .sorted(Comparator.comparing(Student::getSalary).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudentsSortByNameAndSalary(){
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .sorted(Comparator.comparing(Student::getSalary))
                .collect(Collectors.toList());
    }

    public Student getStudentById(int id) throws UserNotFoundException {
        Optional<Student> any = students.stream().filter(i -> i.getId() == id).map(i -> i).findAny();
        if(any.isPresent())
            return any.get();
        throw new UserNotFoundException("User with Id "+id+" is not found");
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudentById(int id) throws UserNotFoundException{
        Optional<Student> first = students.stream().filter(i -> i.getId() == id).findFirst();
      if(first.isPresent())
          students.remove(first.get());
      throw new UserNotFoundException("User with Id "+ id+ " is not found");

    }
}
