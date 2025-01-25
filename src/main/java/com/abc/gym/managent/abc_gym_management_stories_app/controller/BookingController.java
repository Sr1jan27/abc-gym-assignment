package com.abc.gym.managent.abc_gym_management_stories_app.controller;

import com.abc.gym.managent.abc_gym_management_stories_app.dto.BookingRequest;
import com.abc.gym.managent.abc_gym_management_stories_app.model.Booking;
import com.abc.gym.managent.abc_gym_management_stories_app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookClass(@RequestBody BookingRequest bookingRequest){
        Booking booking = bookingService.bookClass(bookingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }
}
