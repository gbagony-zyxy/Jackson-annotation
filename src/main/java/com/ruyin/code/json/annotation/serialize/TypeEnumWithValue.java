package com.ruyin.code.json.annotation.serialize;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {
    TYPE1(1,"TYPE A"),TYPE2(2,"TYPE B");

    private Integer id;
    private String name;

    TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //@JsonValue注解表明序列化的时候只序列化它标注的方法
    @JsonValue
    public String getName() {
        return name;
    }
}
