package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties注解在类级别上标记一个或者一组属性被忽略
// @JsonIgnore注解在属性上标记使得该属性被忽略序列化
@JsonIgnoreProperties({"id"})
public class BeanWithIgnore {
    private int id;
    @JsonIgnore
    private String name;
    private int age;

    public BeanWithIgnore(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BeanWithIgnore(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeanWithIgnore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
