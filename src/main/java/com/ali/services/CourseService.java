package com.ali.services;

import com.ali.models.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alireza on 6/25/19.
 */
@Component
public class CourseService {

    private static List<Course> courses = new ArrayList<>();
    private static int counter =3;

    static {
        courses.add(new Course(1, "course1"));
        courses.add(new Course(2, "course2"));
        courses.add(new Course(3, "course3"));
    }

    public Course addCourse(Course course) {
        if (course.getCode()==null) {
            course.setCode(++counter);
        }
        courses.add(course);
        return course;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse (int code) {
        for (Course course: courses){
            if (course.getCode().equals(code)){
                return course;
            }
        }
        return null;
    }

}
