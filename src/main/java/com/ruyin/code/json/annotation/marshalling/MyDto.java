package com.ruyin.code.json.annotation.marshalling;

/**
 *  @JsonIgnoreProperties注解用于在将对象序列化为Json格式的数据时忽略某一些项的属性
 */
//@JsonIgnoreProperties(value = {"intValue"})
public class MyDto {
    private String stringValue;
    private int intValue;
    private boolean booleanValue;

    public MyDto() {
    }

    public MyDto(String stringValue, int intValue, boolean booleanValue) {
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

    @Override
    public String toString() {
        return "MyDto{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", booleanValue=" + booleanValue +
                '}';
    }
}
