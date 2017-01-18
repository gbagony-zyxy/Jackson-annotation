package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 *  @JsonUnwrapped 注解主要适用于将对象的信息全部展现，而不是嵌套展现(比如一个对象嵌套另外一个对象),对比加与不加的区别
 */
public class UnwrappedUser {
    private int id;

    @JsonUnwrapped
    private Name name;

    public UnwrappedUser() {
    }

    public UnwrappedUser(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public static class Name{
        private String firstName;
        private String lastName;

        public Name() {
        }

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
