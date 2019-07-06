package com.ali.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

/**
 * Created by alireza on 6/25/19.
 */
@ApiModel(description = "Course Details")
public class Course {

    @JsonIgnore
    private Integer code;

    @Size(min = 3, message = "Code should have at least 3 characters")
    @ApiModelProperty(notes = "At least 3 characters")
    private String title;

    public Course() {
    }

    public Course(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code=" + code +
                ", title='" + title + '\'' +
                '}';
    }
}
