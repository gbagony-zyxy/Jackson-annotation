package com.ruyin.code.json.annotation.serialize;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawValue {
    private String name;

    //指定该注解,则输出的内容为该对象原生内容(忽略自身的Jackson注解)，不管该对象是否有Jackson的注解
    @JsonRawValue
    private MyBean myBean;

    public String getName() {
        return name;
    }

    public MyBean getMyBean() {
        return myBean;
    }

    public RawValue(String name, MyBean myBean) {
        this.name = name;
        this.myBean = myBean;
    }
}
