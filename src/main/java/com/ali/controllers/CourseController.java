package com.ali.controllers;

import com.ali.exceptions.CourseNotFoundException;
import com.ali.models.Course;
import com.ali.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by alireza on 6/25/19.
 */

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{code}")
    public Course getCourse(@PathVariable Integer code) {
        Course course = courseService.getCourse(code);
        if (course==null){
            throw  new CourseNotFoundException("Code: " + code);
        }
        return course;
    }

    @PostMapping("/courses")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        Course course1 = courseService.addCourse(course);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{code}")
                .buildAndExpand(course1.getCode()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/courses/{code}")
    public void deleteCourse(@PathVariable Integer code) {
        Course course = courseService.deleteCourse(code);
        if (course==null){
            throw  new CourseNotFoundException("Code: " + code);
        }
    }

}
