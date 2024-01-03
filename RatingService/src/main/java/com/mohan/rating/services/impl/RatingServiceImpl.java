package com.mohan.rating.services.impl;

import com.mohan.rating.entities.Rating;
import com.mohan.rating.repository.RatingRepo;
import com.mohan.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepo ratingRepo;

    @Override
    public List<?> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public <T> T createRating(T rating) {
        return (T) ratingRepo.save((Rating) rating);
    }

    @Override
    public <T> T getRatingByHotalId(String hotelId) {
        List<String>data = new ArrayList<>();
        return (T) ratingRepo.getRatingByHotelId(hotelId);
    }

    @Override
    public <T> T getRatingByUserId(String userId) {
        List<String>data = new ArrayList<>();
        return (T) ratingRepo.getRatingByUserId(userId);
    }
}
