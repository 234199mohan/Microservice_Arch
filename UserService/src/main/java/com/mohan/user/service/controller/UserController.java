package com.mohan.user.service.controller;

import com.mohan.user.service.entities.User;
import com.mohan.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("inside create user method");
        User userData = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userData);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    //@Retry(name="",fallbackMethod = "")
    //@RateLimiter(name="",fallbackMethod = "")
    <T> ResponseEntity getUser(@PathVariable T userId) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.getUser(userId));
    }

    <T> ResponseEntity ratingHotelFallback(T userId, Exception ex) {
        User user = User.builder().email("testmail@gmail.com").name("dummyname").
                about("This user is crested because some service is down").build();
        return new ResponseEntity(user, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        System.out.println("inside getAllUser method");
        return ResponseEntity.ok(userService.customizeUser());
    }
}
