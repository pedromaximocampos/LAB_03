package com.sistemademoeda.api_sistema_moedas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.cors.CorsConfiguration.ALL;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods(ALL)
                        .allowedHeaders(ALL)
                        .allowCredentials(true)
                        .allowedOriginPatterns(ALL);
            }
        };
    }
}
