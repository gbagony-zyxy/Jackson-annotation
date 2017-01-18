package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

/**
 * Created by gbagony on 2017/1/18.
 */
public class UserWithRef {
    private int id;
    private String name;
    @JsonBackReference
    private List<ItemWithRef> userItems;

    public UserWithRef() {
    }

    public UserWithRef(int id, String name, List<ItemWithRef> userItems) {
        this.id = id;
        this.name = name;
        this.userItems = userItems;
    }

    public int getId() {
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
    }

    public List<ItemWithRef> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithRef> userItems) {
        this.userItems = userItems;
    }
}
