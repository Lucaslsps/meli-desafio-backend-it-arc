package com.example.desafiobackenditarc.clients;


import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DesafioBackendItArcApiConfig {

    @Value("${clients.feign.desafioBackendItArcApi.token}")
    private String token;
    public static final String NAME = "desafioBackendItArcApi";

    public static final String NOTIFY_FORECAST = "/notify/forecast";

    public static final String URL = "${clients.feign.desafioBackendItArcApi.url}";
    public static final String PATH = "/api/v1";

    @Bean
    public RequestInterceptor requestInterceptorFaturadorFulfillment() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}
