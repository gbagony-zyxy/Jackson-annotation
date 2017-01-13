package com.ruyin.code.json.annotation.serialize;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *  @JsonProperty可放在属性头以及方法上,可分别由@JsonGetter和@JsonSetter代替(后者只能标注在方法上)
 * */
//设置属性的输出顺序
@JsonPropertyOrder({"lname","id"})
public class MyBean {

    @JsonProperty
    private int id;
    private String name;
    //@JsonIgnore
    @JsonProperty
    private int age;

    public MyBean(int id,String name){
        this.id = id;
        this.name = name;
    }

    public MyBean(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //将一个方法设置为get方法,并设置属性的字段名
    @JsonGetter("lname")
    public String getTheName() {
        return name;
    }

    /*public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }*/

    /*@JsonSetter
    public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
