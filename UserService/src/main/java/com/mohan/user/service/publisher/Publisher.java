package com.mohan.user.service.publisher;

import com.mohan.user.service.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class Publisher implements MessagePublisher {


    RedisTemplate<String, Object> redisTemplate;


    ChannelTopic channelTopic;


    public Publisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
        this.redisTemplate = redisTemplate;
        this.channelTopic = channelTopic;
    }

    public Publisher() {
    }

    @Override
    public void publisher(String message) {
            redisTemplate.convertAndSend(channelTopic.getTopic(), message);
    }
}
