package com.example.mysql_connect.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mysql_connect.model.Hotel;
import com.example.mysql_connect.service.HotelService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/api/hotel")
    public ResponseEntity postMethodName(@RequestBody Hotel hotel) {

        if (hotelService.saveHotel(hotel) == true) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/api/hotels")
    public List<Hotel> getAllDetail() {
        return hotelService.getAllHotel();
    }

    @GetMapping("/api/hotels/{hotelId}")
    public Optional<Hotel> getDetailById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @DeleteMapping("/delete/{id}")
    public void getDeleteId(@PathVariable("id") int id)
    {
        hotelService.delId(id);
    }

    @PutMapping("/update")
    public void updateHotel(@RequestParam int id,@RequestBody Hotel hotel)
    {
        hotelService.updateHotel(id, hotel);
    }
}            