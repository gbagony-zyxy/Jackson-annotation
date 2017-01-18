package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Created by gbagony on 2017/1/18.
 */
public class ItemWithRef {

    private int id;
    private String itemName;
    @JsonManagedReference
    private UserWithRef owner;

    public ItemWithRef() {
    }

    public ItemWithRef(int id, String itemName, UserWithRef owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public UserWithRef getOwner() {
        return owner;
    }

    public void setOwner(UserWithRef owner) {
        this.owner = owner;
    }
}
