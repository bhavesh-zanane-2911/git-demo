package com.bhavesh.newrestapipractice.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.Objects;

@Component
public class Student {

    private int id;
    private String firstName;
    private String city;
    private double salary;

    public Student() {
    }

    public Student(int id, String firstName, String city, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.city = city;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.salary, salary) == 0 && Objects.equals(firstName, student.firstName) && Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, city, salary);
    }
}
