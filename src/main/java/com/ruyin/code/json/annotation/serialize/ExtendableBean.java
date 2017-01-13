package com.ruyin.code.json.annotation.serialize;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gbagony on 2017/1/13.
 */
public class ExtendableBean {

    private String name;
    private Map<String, String> properties = new HashMap<>();

    public ExtendableBean(String name) {
        this.name = name;
    }

    public ExtendableBean add(String key,String value){
        properties.put(key,value);
        return this;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }
}
