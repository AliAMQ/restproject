package com.ali.controllers;

import com.ali.exceptions.CourseNotFoundException;
import com.ali.models.Course;
import com.ali.models.Student;
import com.ali.services.repository.CourseRepository;
import com.ali.services.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by alireza on 6/25/19.
 */

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourse(@PathVariable Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course==null){
            throw  new CourseNotFoundException("Id: " + id);
        }
        return course;
    }

    @PostMapping("/courses")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        Course course1 = courseRepository.save(course);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseRepository.deleteById(id);
    }

    @GetMapping("/courses/{id}/studnts")
    public List<Student> getStudents(@PathVariable Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course==null){
            throw  new CourseNotFoundException("Id: " + id);
        }
        return course.get().getStudentList();
    }

    @PostMapping("/courses/{id}/studnets")
    public ResponseEntity addPost(@PathVariable Integer id, @Valid @RequestBody Student student) {
        Optional<Course> course = courseRepository.findById(id);
        if (course==null){
            throw  new CourseNotFoundException("Id: " + id);
        }

        student.setCourse(course.get());
        studentRepository.save(student);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
