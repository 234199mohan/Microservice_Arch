package com.mohan.rating.repository;

import com.mohan.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> getRatingByUserId( String userId);

    List<Rating> getRatingByHotelId( String hotelId);
}
