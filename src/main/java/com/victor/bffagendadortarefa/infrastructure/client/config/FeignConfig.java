package com.victor.bffagendadortarefa.infrastructure.client.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeingError feingError(){
        return new FeingError();
    }
}
