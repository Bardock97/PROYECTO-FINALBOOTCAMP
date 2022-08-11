package com.bootcamp.userService.userService;

import com.bootcamp.userService.userService.entity.BootCustomer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ConfigRedis {

    @Bean
    ReactiveRedisOperations<String, BootCustomer> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<BootCustomer> serializer = new Jackson2JsonRedisSerializer<>(BootCustomer.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, BootCustomer> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, BootCustomer> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

}
