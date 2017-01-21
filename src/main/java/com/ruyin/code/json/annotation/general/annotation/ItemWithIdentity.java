package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by gbagony on 2017/1/21.
 */
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class
)
public class ItemWithIdentity {
    private int id;
    private String itemName;
    private UserWithIdentity owner;

    public ItemWithIdentity(){}

    public ItemWithIdentity(int id, String itemName, UserWithIdentity owner) {
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

    public UserWithIdentity getOwner() {
        return owner;
    }

    public void setOwner(UserWithIdentity owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ItemWithIdentity{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", owner=" + owner +
                '}';
    }
}
