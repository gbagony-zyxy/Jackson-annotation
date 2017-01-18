##### 1、Jackson Serialization Annotation
###### 1.1、@JsonAnyGetter
```
The @JsonAnyGetter annotation allows flexibility of using a Map field as standard properties.
```
```
public class ExtendableBean {
    public String name;
    private Map<String, String> properties;
    
    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
```
###### 1.2、@JsonGetter
```
The @JsonGetter annotation is an alternative to @JsonProperty annotation to mark the specified method as a getter method.

public class MyBean {
    public int id;
    private String name;
    
    @JsonGetter(“name”)
    public String getTheName() {
        return name;
    }
}
```
###### 1.3、@JsonPropertyOrder
```
The @JsonPropertyOrder annotation is used to specify the order of properties on serialization.

@JsonPropertyOrder({ “name”, “id” })
public class MyBean {
    public int id;
    public String name;
}
```
###### 1.4、@JsonRawValue
```
@JsonRawValue is used to instruct(命令,通知) the Jackson to serialize a property exactly as is(原来的自己,不受自身注解的影响).

public class RawBean {
    public String name;
    @JsonRawValue
    public String json;
}
```
###### 1.5、@JsonValue
```
@JsonValue indicates a single method that should be used to serialize the entire instance.(该注解表明单个的方法将会被序列化)
```
###### 1.6、@JsonRootName
```
The @JSONRootName annotation is used - if wrapping enabled - to specify the name of the root wrapper to be used.

Wrapping means that instead of serializing a User to something like:
{
    “id”: 1,
    “name”: “John”
}
It’s going to be wrapped like this:
{
    “User”: {
    “id”: 1,
    “name”: “John”
    }
}
```
###### 1.7、@JsonSerialize
```
@JsonSerialize is used to indicate a custom serializer will be used to marshall the entity:
```

##### 2、Jackson Deserialization Annotations
###### 2.1、@JsonCreator
```
The @JsonCreator annotation is used to tune the constructor/factory used in deserialization.

It's very helpful when we need to deserialize some json that doesn't exactly match the target entity we need to get.
```

###### 2.2、@JacksonInject
```
@JacksonInject is used to indicate a property that will get its value from injection and not from the JSON data.
```
###### 2.3、@JsonAnySetter
```
@JsonAnySetter allows you the flexibilitu=y of using a Map as standard properties.On deserialization,the properties from Json
will simply be added to the map.

```
###### 2.4、@JsonSetter
```
@JsonSetter is an alternative to @JsonProperty - used to mark the a method as a setter method.
This is super useful when we need to read some json data but the target entity class doesn't exactly match that data and
so we need to tune the process to make it fit.
```
###### 2.5、@JsonDeserialize
```
@JsonDeserialize is used to indicate the use of a custom deserializer.
```
##### 3、@Jackson Property Inclusion Annotations
###### 3.1、@JsonIgnoreProperties
```
@JsonIgnoreProperties - one of common annotations in Jackson - is used to mark a property or a list of properties to be 
ignored at the class level.
```
###### 3.2、@JsonIgnore
```
The @JsonIgnore annotation is used to mark a property to be ignored at the field level.
```
###### 3.3、@JsonIgnoreType
```
@JsonIgnoreType is used to mark all properties of annotated type to be ignored.
```
###### 3.4、@JsonInclude
```
@JsonInclude is used to exclude properties with empty/null/default values.
```
###### 3.5、@JsonAutoDetect
```
@JsonAutoDetect is used to override the default semantics of which properties are visible and which are
not.(该注解用于重载默认语义来决定那些属性可见哪些不可见)
```

##### 5、Jackson Polymorphic(多态) Type Handling Annotations
```
@JsonTypeInfo is used to indicate details of what type infomation is included in serialization.
@JsonSubTypes is used to indicate sub-types of annotated type.
@JsonTypeName is used to define logical type name to use for annotated class.
```

##### 6、Jackson General Annotations
###### 6.1、@JsonProperty
```
@JsonProperty is used to indicate the property name in Json.
We can use @JsonProperty to serialize/deserialize the property name when we're dealing with
non-standard getters and setters.
```
###### 6.2、@JsonFormat
```
The @JsonFotmat annotation can be used to specify a format when serializing Date/Time values.
```
###### 6.3、@JsonUnwrapped
```
@JsonUnwrapped is used to define that a value should be unwrapped/flattened when serialized.
```
###### 6.4、@JsonView
```
@JsonView is used to indicate the View in which the property will be included for serialization/deserialization.
```
###### 6.5、@JsonManagedReference,@JsonBackReference
```
The @JsonManagedReference and @JsonBackReference annotations are used to handle parent/child
relationships and work around loops.
```

