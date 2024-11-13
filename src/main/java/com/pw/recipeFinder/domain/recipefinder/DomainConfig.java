package com.pw.recipeFinder.domain.recipefinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    RecipeFinder recipeFinder(RecipeStorage recipeStorage) {
        return new DefaultRecipeFinder(recipeStorage);
    }
}
