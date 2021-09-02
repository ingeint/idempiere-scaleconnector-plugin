package com.ingeint.scaleconnector.rest.config;

import com.ingeint.scaleconnector.service.ResponseBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ResponseBuilder responseBuilder() {
        return new ResponseBuilder();
    }

}
