package com.mohan.user.service.feign;

import com.mohan.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating rate);

}
