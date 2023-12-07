package com.lms.pharmacyrecommend.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {
    // ObjectMapper => Java Object <-> JSON (Serialization, Deserialization)
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
