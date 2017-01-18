package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  @JsonProperty is used to indicate the property name in Json
 */
public class MyBeanOne {
    private int id;
    @JsonProperty("name")
    private String fname;

    public MyBeanOne() {
    }

    public MyBeanOne(int id, String fname) {
        this.id = id;
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "MyBeanOne{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                '}';
    }
}
