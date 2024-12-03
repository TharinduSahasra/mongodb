package com.example.Student.Backend.with.MongoD.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.Student.Backend.with.MongoD.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
      List<Student> findByYearsOfEnrollment(int yearsOfEnrollment);
      @Query(value = "{ '_id': ?0 }", fields = "{ 'department': 1 }")
      String findDepartmentById(String id);
  
     
      @Transactional
      @Query(value = "{ 'yearsOfEnrollment': ?0 }", delete = true)
      void deleteStudentByYearsOfEnrollment(int yearsOfEnrollment);
    String findDepartmentById(long id);
  
}
