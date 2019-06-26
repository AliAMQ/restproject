package com.ali.models;

/**
 * Created by alireza on 6/25/19.
 */
public class Course {

    Integer code;
    String title;

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
