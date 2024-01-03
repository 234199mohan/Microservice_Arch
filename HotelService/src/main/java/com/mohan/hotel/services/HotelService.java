package com.mohan.hotel.services;

import com.mohan.hotel.entities.Hotel;

import java.util.List;


public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    <T> T getHotelById (String hotelId);
}
