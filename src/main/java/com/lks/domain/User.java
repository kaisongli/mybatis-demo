package com.lks.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by likaisong on 2019/2/24.
 */
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String county;
    private Date date;
    private Integer birthYear;

    public User(){}

    //resultMap 实现新字段赋值
    public User(Integer age){
        this.age = age;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        this.birthYear = Integer.valueOf(simpleDateFormat.format(new Date()))  - age;
    }

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

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date= date;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", county=" + county + ", date=" + date + ", birthYear=" + birthYear + "]";
    }
}