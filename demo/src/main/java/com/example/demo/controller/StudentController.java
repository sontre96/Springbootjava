package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //get All ok
    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    public ResponseEntity listAllStudent(){
        List<Student> listStudent = studentService.getAllStudent();
        if (listStudent.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(listStudent,HttpStatus.OK);
    }

    //get by id ok
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getUStudentById(@PathVariable("id") Long id) {
        Student stu = studentService.getOne(id);
        if (stu == null){
            System.out.println("Not found id: " +id);
        }
        return new ResponseEntity<Student>(stu, HttpStatus.OK);
    }

    //get by code ok
    @RequestMapping(value = "/Student/code", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentByCode(@RequestParam("code") String code) {
        return new ResponseEntity <List<Student>>(studentService.findStudentByCode(code), HttpStatus.OK);
    }

    //get by name ok
    @RequestMapping(value = "/Student/name", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentByName(@RequestParam("name") String name) {
        return new ResponseEntity <List<Student>>(studentService.findStudentByName(name), HttpStatus.OK);
    }

    //get by phone ok
    @RequestMapping(value = "/Student/phone", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentByPhone(@RequestParam("phone") String phone) {
        return new ResponseEntity <List<Student>>(studentService.findStudentByPhone(phone), HttpStatus.OK);
    }

    //get by email ok
    @RequestMapping(value = "/Student/email", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentByEmail(@RequestParam("email") String email) {
        return new ResponseEntity <List<Student>>(studentService.findStudentByEmail(email), HttpStatus.OK);
    }

    //Add ok
    @RequestMapping(value = "/Student", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    // Update ok
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,
                                           @RequestBody Student student)
    {
        Student oldStudent = studentService.getOne(id);
        if (oldStudent == null){
            return ResponseEntity.notFound().build();
        } else {
            oldStudent.setCode(student.getCode());
            oldStudent.setName(student.getName());
            oldStudent.setAddress(student.getAddress());
            oldStudent.setPhone(student.getPhone());
            oldStudent.setEmail(student.getEmail());

            student = studentService.saveStudent(oldStudent);
            return ResponseEntity.ok(oldStudent);
        }
    }

    //Delete ok
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
        Optional<Student> student = studentService.findStudentById(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        } else {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    }
}
