package com.jb.bookandauthor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigSwager {
    @Bean
    public RestTemplate restTemplate(){
        return restTemplate();
    }
}
