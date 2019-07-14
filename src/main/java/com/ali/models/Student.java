package com.ali.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "Student Details")
@Entity
public class Student {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    @ApiModelProperty(notes = "Between 3-15 characters")
    @Size(min = 3, max =15 , message = "Firstname should be between 3-15 characters")
    private String firstname;

    private String lastname;

    //Assuming each student may have just one course
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Course course;

    public Student() {
    }

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId().equals(student.getId()) &&
                getFirstname().equals(student.getFirstname()) &&
                getLastname().equals(student.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                '}';
    }
}
