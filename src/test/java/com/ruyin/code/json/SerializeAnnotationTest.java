package com.ruyin.code.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ruyin.code.json.annotation.serialize.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SerializeAnnotationTest {

    @Test
    public void whenSerializingUsingJsonAnyGetter() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("mybean");
        bean.add("attr1","val1");
        bean.add("attr2","val2");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonProperty() throws JsonProcessingException {
        MyBean bean = new MyBean(1,"mybean",24);

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonRaw() throws JsonProcessingException {
        RawValue bean = new RawValue("rawValue",new MyBean(1,"mybean",24));

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingJsonValue() throws JsonProcessingException {
        String eStr = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println(eStr);
    }

    @Test
    public void whenSerializingUsingJsonRootName() throws JsonProcessingException {
        UserWithRoot user1 = new UserWithRoot(24,"zxc");
        UserWithRoot user2 = new UserWithRoot(25,"qwe");
        UserWithRoot user3 = new UserWithRoot(26,"asd");


        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(Arrays.asList(user1,user2,user3));

        System.out.println(result);
    }

    @Test
    public void whenSerilizingUsingJsonSerialize() throws ParseException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2017 14:16:30";

        Date date = format.parse(toParse);

        Event event = new Event("party",date);
        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }
}
