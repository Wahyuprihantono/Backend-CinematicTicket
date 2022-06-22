package com.bioskop.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

    @ConfigurationPropertiesScan
    public class CacheConfig {

        @Bean
        public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
            return (builder) -> builder
                    .withCacheConfiguration("getAllFilms",
                            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)))
                    .withCacheConfiguration("getFilmByFilmName",
                            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)))
                    .withCacheConfiguration("getAllUsers",
                            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
        }

        @Bean
        public RedisCacheConfiguration cacheConfiguration() {
            return RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(Duration.ofMinutes(60))
                    .disableCachingNullValues()
                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        }
    }
