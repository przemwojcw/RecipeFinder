package com.pw.recipeFinder.infrastructure;

import com.pw.recipeFinder.domain.recipefinder.RecipeStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class InfrastructureConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);
        return template;
    }

    @Bean
    @ConditionalOnMissingBean
    RecipeStorage recipeStorage(RedisTemplate<String, Object> redisTemplate) {
        return new DefaultRecipeStorage(redisTemplate);
    }

    @Bean
    @ConditionalOnProperty(name = "app.environment", havingValue = "local")
    RecipeStorage mockRecipeStorage() {
        return name -> "test";
    }
}
