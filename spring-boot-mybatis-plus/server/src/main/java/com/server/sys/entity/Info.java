package com.server.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author YuHong
 * @since 2023-09-13
 */
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    private String name;

    private Integer age;

    public Info() {}

    public Info(String id, String name, Integer age, String gender, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.major = major;
    }

    private String gender;

    private String major;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Info{" +
            "id = " + id +
            ", name = " + name +
            ", age = " + age +
            ", gender = " + gender +
            ", major = " + major +
        "}";
    }
}
