package com.ruyin.code.json.annotation.general.annotation;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *  @JsonFormat annotation can be used to specify a format when serializing Date/Time values.
 */
public class TimeEvent {

    private String name;

    @JsonFormat(
            //shape = JsonFormat.Shape.STRING,
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss"
    )
    private Date eventDate;

    public TimeEvent(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
