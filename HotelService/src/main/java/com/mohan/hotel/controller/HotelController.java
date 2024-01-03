package com.mohan.hotel.controller;

import com.mohan.hotel.entities.Hotel;
import com.mohan.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping
    ResponseEntity<List<Hotel>> getAllHotel() {
        List<Hotel> hotels = hotelService.getAllHotel();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping
    ResponseEntity<Hotel> creteHotel(@RequestBody Hotel hotel) {
        Hotel hotelData = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelData);
    }

    @GetMapping("/{hotelId}")
    ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        System.out.println("inside hotel by ID");
        Hotel hotelData = hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelData);
    }



}
