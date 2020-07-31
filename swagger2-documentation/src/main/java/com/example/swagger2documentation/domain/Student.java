package com.example.swagger2documentation.domain;

public class Student {
    private String name;
    private String cls;
    private String country;

    public Student() {
    }

    public Student(String name, String cls, String country) {
        this.name = name;
        this.cls = cls;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCls() {
        return cls;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cls='" + cls + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
