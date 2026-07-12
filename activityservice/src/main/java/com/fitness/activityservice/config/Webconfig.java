package com.fitness.activityservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Webconfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuiler() {
        return WebClient.builder();
    }

    @Bean
    public WebClient userServiceWebclient(WebClient.Builder webclientBuiler) {
        return webclientBuiler.baseUrl("http://USERSERVICE")
                .build();
    }
}
