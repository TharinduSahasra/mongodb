package com.example.Student.Backend.with.MongoD.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.Student.Backend.with.MongoD.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
      List<Student> findByYearOfEnrollment(int yearOfEnrollment);
     @Query("SELECT department FROM Student WHERE id = ?1")
    String findDepartmentById(String id); // Custom method to fetch students by department
 
}
