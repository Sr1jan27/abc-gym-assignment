package com.abc.gym.managent.abc_gym_management_stories_app.controller;

import com.abc.gym.managent.abc_gym_management_stories_app.model.Booking;
import com.abc.gym.managent.abc_gym_management_stories_app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings/search")
public class BookingSearchController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> searchBookings(@RequestParam(required = false) String memberName,
                                                        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
                                                        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate) {
        List<Booking> bookings =  bookingService.searchBookings(memberName, startDate, endDate);
        return ResponseEntity.ok(bookings);
    }
}
