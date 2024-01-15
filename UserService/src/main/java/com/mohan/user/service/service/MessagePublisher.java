package com.mohan.user.service.service;

import org.springframework.stereotype.Component;

@Component
public interface MessagePublisher {




    void publisher(String message);
}
