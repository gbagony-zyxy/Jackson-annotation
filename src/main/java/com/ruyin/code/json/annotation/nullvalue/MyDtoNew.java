package com.ruyin.code.json.annotation.nullvalue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *  用于设置全局的空值处理
 */
//按照字母表顺序输出
//@JsonPropertyOrder(alphabetic = true)
//自定义输出,此处既可以指定原始属性,也可指定更改后的属性名
//@JsonPropertyOrder(value = {"stringValue","intValue","address"})
@JsonPropertyOrder(value = {"strVal","intValue","address"})
public class MyDtoNew {

    private String stringValue;
    private int intValue;
    private String address;


    public MyDtoNew() {
    }

    public MyDtoNew(String stringValue, int intValue, String address) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.address = address;
    }

    @JsonProperty("strVal")
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
