package com.bezkoder.spring.jpa.h2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class CorsConfig {
      
 
      
        @Bean
        public WebMvcConfigurer corsConfigurer() {
                return new WebMvcConfigurer() {
                        @Override
                        public void addCorsMappings(CorsRegistry registry) {
                                registry
                                                .addMapping("/**")
                                                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                                                .allowedOrigins("*").allowedHeaders("*");
                        }
                };
        }
 
}