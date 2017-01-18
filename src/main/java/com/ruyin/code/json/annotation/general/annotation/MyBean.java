package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  @JsonProperty is used to indicate the property name in Json
 */
public class MyBean {
    private int id;
    private String name;

    public MyBean() {
    }

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }

    @JsonProperty("name")
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
