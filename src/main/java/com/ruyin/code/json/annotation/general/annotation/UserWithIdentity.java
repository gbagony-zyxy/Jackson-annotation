package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

/**
 *  @JsonIdentityInfo 注解用于在序列化或者反序列化值时用于指示该对象的身份,该注解可以用于处理无限递归类的问题
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class UserWithIdentity {
    private int id;
    private String name;
    private List<ItemWithIdentity> userItems = new ArrayList<>();

    public UserWithIdentity(){}

    public UserWithIdentity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserWithIdentity(int id, String name, List<ItemWithIdentity> userItems) {
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

    public List<ItemWithIdentity> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithIdentity> userItems) {
        this.userItems = userItems;
    }

    public UserWithIdentity add(ItemWithIdentity item){
        userItems.add(item);
        return this;
    }
}
