package com.example.Student.Backend.with.MongoD.service;

import java.util.List;

import com.example.Student.Backend.with.MongoD.model.Student;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String id); // Changed `string` to `String`
    Student updateStudent(Student student, String id); // Changed `string` to `String`
    void deleteStudent(String id); // Changed `string` to `String`
    List<Student> getStudentsByYearOfEnrollment(int yearOfEnrollment);
    String findDepartmentById(String id);}