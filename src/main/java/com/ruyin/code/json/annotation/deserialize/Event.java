package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class Event {
    private String name;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date eventDate;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
