package com.mohan.user.service.config;

import com.mohan.user.service.publisher.Publisher;
import com.mohan.user.service.service.MessagePublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    LettuceConnectionFactory lettuceConnectionFactory(){
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("localhost");
        config.setPort(6379);
        return new LettuceConnectionFactory(config);
    }

    @Bean
    ChannelTopic topic(){
        return new ChannelTopic("smsQueue");
    }


    @Bean
    RedisTemplate<String,Object>redisTemplate (){
        RedisTemplate<String,Object> temp = new RedisTemplate<>();
        temp.setConnectionFactory(lettuceConnectionFactory());
        temp.setKeySerializer(new StringRedisSerializer());
        temp.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        temp.afterPropertiesSet();
        return temp;
    }


    @Bean
    MessagePublisher messagePublisher(){
        return new Publisher(redisTemplate(),topic());
    }
}
