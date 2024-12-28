package com.example.Student.Backend.with.MongoD.service;

import java.util.List;

import com.example.Student.Backend.with.MongoD.model.Student;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String id); 
    Student updateStudent(Student student, String id);
    void deleteStudent(String id); 
    List<Student> getStudentByYearsOfExperience(int yearsOfEnrollment);
    String findDepartmentById(String id);
    String deleteStudentByYearsOfEnrollment(int yearsOfEnrollment);
}