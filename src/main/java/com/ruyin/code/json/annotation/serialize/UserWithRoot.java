package com.ruyin.code.json.annotation.serialize;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *  @JsonRootName将对象封装成一个对象，并指定json对象的名称
 * */
@JsonRootName(value = "user")
public class UserWithRoot {

    private int id;
    private String name;

    public UserWithRoot(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
