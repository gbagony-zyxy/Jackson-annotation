package com.ruyin.code.json.annotation.marshalling;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * Created by gbagony on 2017/1/21.
 */
@JsonFilter("basicType")
public class MyDtoWithFilter {

    private int intValue;
    private String stringValue;
    private double doubleValue;
    private float floatValue;
    private byte[] bytesValue;

    public MyDtoWithFilter() {
    }

    public MyDtoWithFilter(int intValue, String stringValue, double doubleValue, float floatValue, byte[] bytesValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.doubleValue = doubleValue;
        this.floatValue = floatValue;
        this.bytesValue = bytesValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public byte[] getBytesValue() {
        return bytesValue;
    }

    public void setBytesValue(byte[] bytesValue) {
        this.bytesValue = bytesValue;
    }
}
