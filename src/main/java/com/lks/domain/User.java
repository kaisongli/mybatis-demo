package com.lks.domain;

import java.io.Serializable;

/**
 * Created by likaisong on 2019/2/24.
 */
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String county;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCounty() {
        return county;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", county=" + county + "]";
    }
}