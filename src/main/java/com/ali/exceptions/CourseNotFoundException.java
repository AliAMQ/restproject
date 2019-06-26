package com.ali.exceptions;

/**
 * Created by alireza on 6/26/19.
 */
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String s) {
        super(s);
    }
}
