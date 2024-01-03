package com.mohan.rating.controllers;

import com.mohan.rating.entities.Rating;
import com.mohan.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    ResponseEntity<Rating> createRating(@RequestBody Rating rate) {
        Rating rating = ratingService.createRating(rate);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    @GetMapping
    ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> ratings = (List<Rating>) ratingService.getAllRating();
        return ResponseEntity.ok(ratings);
    }


    @GetMapping("/users/{userId}")
    ResponseEntity<List<Rating>>getRatingByUserId(@PathVariable  String userId){
        System.out.println("inside rating by userId");
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    ResponseEntity<List<Rating>>getRatingByHotelId(@PathVariable  String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotalId(hotelId));
    }


}
