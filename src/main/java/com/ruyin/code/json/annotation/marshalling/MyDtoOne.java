package com.ruyin.code.json.annotation.marshalling;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *  @JsonIgnore注解若标注在对象的属性上，在序列化的之时则会忽略该注解标注的属性
 */
public class MyDtoOne {
    private String stringValue;
    @JsonIgnore
    private int intValue;
    private boolean booleanValue;

    public MyDtoOne() {
    }

    public MyDtoOne(String stringValue, int intValue, boolean booleanValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.booleanValue = booleanValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
}
