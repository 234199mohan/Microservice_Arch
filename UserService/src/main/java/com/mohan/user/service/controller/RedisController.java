package com.mohan.user.service.controller;

import com.mohan.user.service.publisher.Publisher;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    Publisher publisher;


    @RequestMapping(value = "/publisher",method= RequestMethod.POST)
    public void publish(@RequestBody String message){
        logger.info("........Publishing......" +message);
        publisher.publisher(message);

    }
}
