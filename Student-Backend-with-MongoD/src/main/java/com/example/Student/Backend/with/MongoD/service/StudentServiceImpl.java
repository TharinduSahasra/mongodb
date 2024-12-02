package com.example.Student.Backend.with.MongoD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Backend.with.MongoD.model.Student;
import com.example.Student.Backend.with.MongoD.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(Student student, String id) {
        // Find the existing student or throw an exception
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        // Update fields
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());

        // Save and return the updated student
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        // Check if the student exists before attempting deletion
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

    @Override
    public List<Student> getStudentsByYearOfEnrollment(int yearOfEnrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public String findDepartmentById(String id){
        return studentRepository.findDepartmentById(id);
    }
}

   
