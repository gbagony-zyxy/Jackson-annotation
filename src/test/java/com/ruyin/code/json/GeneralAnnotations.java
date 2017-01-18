package com.ruyin.code.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruyin.code.json.annotation.general.annotation.*;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 */
public class GeneralAnnotations {

    @Test
    public void testJsonProperty() throws IOException {
        MyBean bean = new MyBean(1024,"good game");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        //现在使用readerFor()代替原来的reader()
        MyBean beanOne = new ObjectMapper().readerFor(MyBean.class).readValue(result);
        System.out.println(beanOne);

        MyBeanOne bean1 = new MyBeanOne(1025,"gg");
        String result1 = new ObjectMapper().writeValueAsString(bean1);
        System.out.println(result1);

        MyBeanOne beanOne1 = new ObjectMapper().readerFor(MyBeanOne.class).readValue(result1);
        System.out.println(beanOne1);
    }

    @Test
    public void testJsonFormat() throws ParseException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC/GMT+08:00"));

        String needParsedStr = "18-01-2017 21:01:40";
        Date date = sdf.parse(needParsedStr);

        TimeEvent event = new TimeEvent("nice day",date);
        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonUnwrapped() throws JsonProcessingException {

        UnwrappedUser user1 = new UnwrappedUser(23,new UnwrappedUser.Name("John1","Doe"));
        UnwrappedUser user2 = new UnwrappedUser(24,new UnwrappedUser.Name("John2","Doe"));
        UnwrappedUser user3 = new UnwrappedUser(25,new UnwrappedUser.Name("John3","Doe"));
        String result = new ObjectMapper().writeValueAsString(Arrays.asList(user1,user2,user3));
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonView() throws JsonProcessingException {
        Item item = new Item(25,"goods","ruyin");
        //指明展示那些标识指明的属性
        String result = new ObjectMapper().writerWithView(Views.Public.class)
                .writeValueAsString(item);
        System.out.println(result);
    }
}
