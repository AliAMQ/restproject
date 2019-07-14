package com.ali.controllers;

import com.ali.configs.Configuration;
import com.ali.exceptions.CourseNotFoundException;
import com.ali.models.Student;
import com.ali.services.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Configuration configuration;

    @GetMapping("/students")
    public List<Student> getStudnets() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudnet(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()){ throw  new CourseNotFoundException("Id: " + id);}
        return student;
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        Student student1 = studentRepository.save(student);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudnet(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/maxstudents")
    public int getMax(){
        return configuration.getMax();
    }
}
