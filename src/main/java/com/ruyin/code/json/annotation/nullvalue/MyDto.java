package com.ruyin.code.json.annotation.nullvalue;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *  @JsonInclude注解用在类上则作用于整个类的属性和方法,作用于单个属性上同样只适用于单属性
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stringValue;
    private int intValue;
    private String address;


    public MyDto() {
    }

    public MyDto(String stringValue, int intValue, String address) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
