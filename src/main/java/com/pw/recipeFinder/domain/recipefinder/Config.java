package com.pw.recipeFinder.domain.recipefinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    RecipeFinder recipeFinder() {
        return new DefaultRecipeFinder();
    }
}
