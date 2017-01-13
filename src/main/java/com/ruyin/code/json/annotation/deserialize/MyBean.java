package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

// @JsonInclude注解用于包含一些属性，可供选择的有empty/null/default等
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyBean {
    private int id;
    private String name;

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    /*public String getName() {
        return name;
    }*/

    // JsonSetter注解将一个方法标记为某个属性的set方法，并可以指定属性名称
    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
