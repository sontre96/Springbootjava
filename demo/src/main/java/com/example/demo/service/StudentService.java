package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    Optional<Student> findStudentById(Long id);

    public Student getOne(Long id);
    public List<Student> findStudentByName(String name);
    public List<Student> findStudentByCode(String code);
    public List<Student> findStudentByPhone(String phone);
    public List<Student> findStudentByEmail(String email);


}
