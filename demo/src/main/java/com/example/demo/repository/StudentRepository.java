package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAllByOrderByIdAsc();
    public List<Student> findAllByOrderByIdDesc();
    public List<Student> findAllByOrderByNameDesc();

    public List<Student> findStudentByName(String name);
    public List<Student> findStudentByCode(String code);
    public List<Student> findStudentByPhone(String phone);
    public List<Student> findStudentByEmail(String email);

}
