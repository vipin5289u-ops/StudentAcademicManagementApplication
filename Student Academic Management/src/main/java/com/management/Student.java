package com.management;

public class Student {
    private String name;
    private Integer id;
    private String course;
    public Student() {

    }
    public Student(String name, Integer id, String course) {
        this.name = name;
        this.id = id;
        this.course = course;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}