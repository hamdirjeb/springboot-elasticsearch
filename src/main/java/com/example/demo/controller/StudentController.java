package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public String save(@RequestBody Student student) throws IOException {
        studentService.saveStudent(student);
        return "User indexed";
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) throws IOException {
        return studentService.searchByName(name);
    }
}
