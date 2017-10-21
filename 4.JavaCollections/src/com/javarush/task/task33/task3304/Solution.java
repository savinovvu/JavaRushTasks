package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(writer, one);
        String jsonString = writer.toString();
        String oneClassName = one.getClass().getSimpleName().toLowerCase();
        String anotherClass = resultClassObject.getSimpleName().toLowerCase();
        String resultJson = jsonString.replaceFirst(oneClassName, anotherClass);
        return objectMapper.readValue(new StringReader(resultJson), resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}

/*JsonNode root = objectMapper.readTree(jsonString);
        JsonNode className = root.get("className");
        if ("first".equals(className)) {
            return objectMapper.readValue(jsonString, Second.class);
        }
        if ("second".equals(className)) {
            return objectMapper.readValue(jsonString, First.class);
        }*/
