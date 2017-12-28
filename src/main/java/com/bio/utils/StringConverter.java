package com.bio.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class StringConverter {

    private ObjectMapper objectMapper;

    @Autowired
    public StringConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> String convertForHTTPsend(T t) {
        String str = null;
        try {
            str = objectMapper
                    .writeValueAsString(t)
                    .replace("\"", "\\\"");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public <T> String convert(T t) {
        String str = null;
        try {
            str = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public <T> T convert(String s, Class<T> clazz) {
        T object = null;
        try {
            object = objectMapper.readValue(s, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
