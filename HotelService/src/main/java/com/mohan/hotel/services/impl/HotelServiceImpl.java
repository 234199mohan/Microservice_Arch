package com.mohan.hotel.services.impl;

import com.mohan.hotel.entities.Hotel;
import com.mohan.hotel.repositories.HotelRepo;
import com.mohan.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;


    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public <T> T getHotelById (String hotelId) {

        return (T) hotelRepo.findById(hotelId).orElseThrow();
    }
}
