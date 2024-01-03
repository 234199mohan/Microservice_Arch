package com.mohan.rating.services;

import com.mohan.rating.entities.Rating;

import java.util.List;

public interface RatingService {


    List<?> getAllRating();

    <T> T createRating (T rating);

    <T> T getRatingByHotalId (String hotelId);

    <T> T getRatingByUserId (String userId);
}
