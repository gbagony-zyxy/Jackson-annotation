package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("inject")
public class BeanWithInject {

    //@JacksonInject注解用于指定当json中未指定值时使用指定的值取代默认值
    @JacksonInject
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BeanWithInject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
