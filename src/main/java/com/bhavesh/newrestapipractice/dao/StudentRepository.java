package com.bhavesh.newrestapipractice.dao;

import com.bhavesh.newrestapipractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
