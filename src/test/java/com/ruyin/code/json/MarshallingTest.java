package com.ruyin.code.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ruyin.code.json.annotation.general.annotation.MyMixInForString;
import com.ruyin.code.json.annotation.marshalling.MyDto;
import com.ruyin.code.json.annotation.marshalling.MyDtoOne;
import com.ruyin.code.json.annotation.marshalling.MyDtoWithFilter;
import com.ruyin.code.json.annotation.nullvalue.MyDtoNew;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by gbagony on 2017/1/21.
 */
public class MarshallingTest {

    @Test
    public void givenFieldIsIgnoredByName() throws JsonProcessingException {
        MyDto dto = new MyDto();
        String result = new ObjectMapper().writeValueAsString(dto);
        System.out.println(result);
    }

    @Test
    public void givenFieldIsIgnoredDirectly() throws JsonProcessingException {
        MyDtoOne dto = new MyDtoOne();
        String result = new ObjectMapper().writeValueAsString(dto);
        System.out.println(result);
    }

    @Test
    public void givenFieldTypeIsIgnored() throws JsonProcessingException {
        MyDto dto = new MyDto("gg",23,true);
        String result = new ObjectMapper().addMixIn(String.class,MyMixInForString.class).writeValueAsString(dto);
        System.out.println(result);
    }

    @Test
    public void givenTypeHasFilterThatIgnoresFieldByName() throws JsonProcessingException {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("intValue","stringValue");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("basicType",filter);

        MyDtoWithFilter dto = new MyDtoWithFilter(21,"haha",0.24569, (float) 0.24569,new byte[]{3,1,'a','b'});
        String result = new ObjectMapper().writer(filterProvider).writeValueAsString(dto);
        System.out.println(result);
    }

    @Test
    public void givenNullIsIgnoredOnClass() throws JsonProcessingException {
        com.ruyin.code.json.annotation.nullvalue.MyDto dto = new com.ruyin.code.json.annotation.nullvalue.MyDto(null,25,null);
        String result = new ObjectMapper().writeValueAsString(dto);
        System.out.println(result);
    }

    @Test
    public void givenNullIsIgnoredGlobally() throws JsonProcessingException {
        MyDtoNew bean = new MyDtoNew(null,21,null);
        String result = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void givenNameOfFieldIsChanged() throws JsonProcessingException {
        MyDtoNew bean = new MyDtoNew("gg",21,"dd");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenParsingJsonStringIntoJsonNode() throws IOException {
        String jsonStr = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
        JsonNode actualObj = new ObjectMapper().readTree(jsonStr);
        System.out.println(actualObj);
    }

    @Test
    public void givenUsingLowLevelApi() throws IOException {
        String jsonStr = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
        JsonParser parser = new ObjectMapper().getFactory().createParser(jsonStr);
        JsonNode actualObj = new ObjectMapper().readTree(parser);
        System.out.println(actualObj);
    }

    @Test
    public void givenTheJsonNode() throws IOException {
        String jsonStr = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
        JsonNode actualObj = new ObjectMapper().readTree(jsonStr);

        //when
        JsonNode node1 = actualObj.get("k1");
        System.out.println(node1);
    }

    //@Test(expected = UnrecognizedPropertyException.class)
    @Test
    public void givenJsonHasUnknoownValues() throws IOException {
        String jsonAsStr = "{\"stringValue\":\"q\"," +
                "\"intValue\":\"1\"," +
                "\"stringValue2\":\"something\"}";
        MyDto dto = new ObjectMapper().readValue(jsonAsStr,MyDto.class);
        System.out.println(dto);
    }

    @Test
    public void givenJsonHasUnknownValuesButJscksonIsIgnoringUnknowns() throws IOException {
        String jsonAsStr = "{\"stringValue\":\"q\"," +
                "\"intValue\":\"1\"," +
                "\"stringValue2\":\"something\"}";
        MyDto dto = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(jsonAsStr,MyDto.class);
        System.out.println(dto);
    }

    @Test
    public void givenNotAllFieldsHaveValuesInJson() throws IOException {
        String jsonAsStr = "{\"stringValue\":\"q\"," +
                "\"intValue\":\"1\"}";

        MyDto dto = new ObjectMapper().readValue(jsonAsStr,MyDto.class);
        System.out.println(dto);
    }
}
