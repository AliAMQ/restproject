package com.ali.controllers;

import com.ali.models.Course;
import com.ali.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by alireza on 6/25/19.
 */

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/courses")
    public ResponseEntity addCourse(@RequestBody Course course) {
        Course course1 = courseService.addCourse(course);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course1.getCode()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
