package com.pw.recipeFinder.infrastructure;

import com.pw.recipeFinder.domain.recipefinder.RecipeStorage;
import org.springframework.data.redis.core.RedisTemplate;

class DefaultRecipeStorage implements RecipeStorage {
    private final RedisTemplate<String, Object> redisTemplate;

    DefaultRecipeStorage(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String findRecipe(String name) {
        redisTemplate.opsForValue().set("test", "testRedis");
        return (String) redisTemplate.opsForValue().get("test");
    }
}
