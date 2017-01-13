package com.ruyin.code.json.annotation.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Event {
    public String name;

    //@JsonSerialize允许用户对属性进行一些个性化的处理(用自己定义的结构)
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public Event(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}
