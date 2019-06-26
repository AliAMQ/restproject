package com.ali.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alireza on 6/26/19.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) //not mandatory if there is a generic exception handling for all resources:
                                        // like ExceptionResponse.java and AliResponseEntityExceptionHandler.java
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String s) {
        super(s);
    }
}
