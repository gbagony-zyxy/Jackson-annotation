package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Map;

public class ExtendableBean {
    private String name;
    private Map<String,String> properties;

    @JsonAnySetter
    public void add(String key, String value){
        properties.put(key,value);
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "ExtendableBean{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}
