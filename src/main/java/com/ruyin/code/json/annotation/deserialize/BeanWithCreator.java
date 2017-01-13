package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanWithCreator {
    private int id;
    private String name;

    //@JsonCreator 注解是在反序列化时置于构造函数或者工厂方法上,参照注解的源码理解
    //单参的构造函数不需要指定@JsonProperty注解,多参则需指定
    @JsonCreator
    public BeanWithCreator(
            @JsonProperty("id")int id,
            @JsonProperty("lname")String name){
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public BeanWithCreator(String name){
        this.name = name;
    }

    /*@JsonValue
    public String getName() {
        return name;
    }*/

    @Override
    public String toString() {
        return "BeanWithCreator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
