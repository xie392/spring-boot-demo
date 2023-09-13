package com.example.javaweb.example.entity;

public class InfoEntity {
    private String name;

    public InfoEntity(String name, Integer age, String gender, String major) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.major = major;
    }

    private Integer age;
    private String gender;
    private String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
