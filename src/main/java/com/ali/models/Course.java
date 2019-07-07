package com.ali.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by alireza on 6/25/19.
 */
@ApiModel(description = "Course Details")
@Entity
public class Course {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", code=" + code +
                ", title='" + title + '\'' +
                '}';
    }
}
