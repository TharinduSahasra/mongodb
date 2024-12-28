package com.example.Student.Backend.with.MongoD.service;

import java.util.List;


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
        
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearsOfEnrollment(student.getYearsOfEnrollment());

        
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
    @Override
    public List<Student> getStudentByYearsOfExperience(int years){
        return studentRepository.findByYearsOfEnrollment(years);
    }
   
    @Override
    public String deleteStudentByYearsOfEnrollment(int years){
        studentRepository.deleteStudentByYearsOfEnrollment(years);
        return "Deleted Successfully";
    }

    @Override
public String findDepartmentById(String id) {
 
    if (id == null || id.isEmpty()) {
        throw new IllegalArgumentException("ID must not be null or empty");
    }

    
    String department = studentRepository.findDepartmentById(id);

    
    if (department == null) {
        throw new RuntimeException("Department not found for ID: " + id);
    }

    return department;
}

    
}

   
