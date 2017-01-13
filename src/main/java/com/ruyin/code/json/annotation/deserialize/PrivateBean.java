package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//@JsonAutoDetect 注解标注在类上用于指定何种级别(public/private/protected)的属性能够被检测到
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrivateBean {
    private int id;
    private String name;

    public PrivateBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*public int getId() {
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
    }*/
}
