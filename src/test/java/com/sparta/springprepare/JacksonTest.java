package com.sparta.springprepare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springprepare.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    @DisplayName("Object To JSON: required get Method")
    void testGetMethodRequire() throws JsonProcessingException {
        Star star = new Star("kyeonkim", 95);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(star);

        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON To Object : required default constructor & (get OR set) Method")
    void testGetMethodRequire2() throws JsonProcessingException {
        String json = "{\"name\":\"kyeonkim\",\"age\":90}";

        ObjectMapper objectMapper = new ObjectMapper();

        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
        System.out.println("star.getAge() = " + star.getAge());
    }
}
