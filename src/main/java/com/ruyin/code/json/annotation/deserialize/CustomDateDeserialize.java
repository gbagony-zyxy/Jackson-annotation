package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//自定义的用户解析代码，继承于JsonDeserializer
public class CustomDateDeserialize extends JsonDeserializer<Date>{
    private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText();
        try {
          return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
