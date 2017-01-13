package com.ruyin.code.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruyin.code.json.annotation.deserialize.*;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class DeserializeAnnotationTest {

    @Test
    public void whenDeserializingUsingJsonCreator() throws IOException {
        String json1 = "{\"id\":12,\"lname\":\"mybean\"}";
        String json2 = "{\"lname\":\"mybean1\"}";
        BeanWithCreator creator = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json2);
        System.out.println(creator);
    }

    @Test
    public void whenDeserializingUsingJsonInject() throws IOException {
        String json1 = "{\"id\":12,\"name\":\"myBean\"}";
        String json2 = "{\"name\":\"myBean\"}";

        InjectableValues inject = new InjectableValues.Std().addValue(int.class,14);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json2);
        System.out.println(bean.toString());
    }

    @Test
    public void whenDeserializingUsingJsonAnySetter() throws IOException {
        String json = "{\"name\":\"mybean\",\"properties\":{\"attr2\":\"val2\",\"attr1\":\"val1\"}}";
        //String json = "{\"name\":\"mybean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";


        ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class).readValue(json);
        System.out.println(bean);
    }

    @Test
    public void whenDeserializingUsingJsonSetter() throws IOException {
        String json = "{\"id\":23,\"name\":\"setterBean\"}";

        MyBean bean = new ObjectMapper().readerFor(MyBean.class).readValue(json);
        System.out.println(bean);
    }

    @Test
    public void whenDeserializingUsingJsonDeserialize() throws IOException {
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2016 02:30:00\"}";

        SimpleDateFormat format = new SimpleDateFormat("dd-Mm-yyyy hh:mm:ss");
        Event event = new ObjectMapper().readerFor(Event.class).readValue(json);
        System.out.println(event);
    }

    @Test
    public void whenSerializingUsingJsonIgnoreProperties() throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1,"ignoreProperties",24);
        System.out.println(new ObjectMapper().writeValueAsString(bean));
    }

    @Test
    public void whenSerializingUsingJsonIgnoreType() throws JsonProcessingException {
        User.Name name = new User.Name("Jhon","Doe");
        User user = new User(12,name);

        System.out.println(new ObjectMapper().writeValueAsString(user));
    }

    @Test
    public void whenSerializingUsingJsonInclude() throws JsonProcessingException {
        MyBean bean = new MyBean(12,null);
        System.out.println(new ObjectMapper().writeValueAsString(bean));
    }

    @Test
    public void whenSerializingUsingJsonAutoDetect() throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(25,"privateBean");
        System.out.println(new ObjectMapper().writeValueAsString(bean));
    }

    @Test
    public void whenSerializingPolymorphic() throws JsonProcessingException {
        Zoo.Dog dog = new Zoo(). new Dog("lacy");
        Zoo zoo = new Zoo(dog);

        System.out.println(new ObjectMapper().writeValueAsString(zoo));
    }

    @Test
    public void whenDeserializingPolymorphic() throws IOException {
        String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\"}";
        Zoo zoo = new ObjectMapper().readerFor(Zoo.class).readValue(json);
        System.out.println(zoo);
    }
}
