package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getOne(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public List<Student> findStudentByCode(String code) {
        return studentRepository.findStudentByCode(code);
    }

    @Override
    public List<Student> findStudentByPhone(String phone) {
        return studentRepository.findStudentByPhone(phone);
    }

    @Override
    public List<Student> findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }


}
