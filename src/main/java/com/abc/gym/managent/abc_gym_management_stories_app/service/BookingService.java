package com.abc.gym.managent.abc_gym_management_stories_app.service;

import com.abc.gym.managent.abc_gym_management_stories_app.dto.BookingRequest;
import com.abc.gym.managent.abc_gym_management_stories_app.model.Booking;
import com.abc.gym.managent.abc_gym_management_stories_app.model.GymClass;
import com.abc.gym.managent.abc_gym_management_stories_app.repo.BookingRepository;
import com.abc.gym.managent.abc_gym_management_stories_app.repo.GymClassRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class BookingService {


    @Autowired
    GymClassRepository gymClassRepository;

    @Autowired
    BookingRepository bookingRepository;


    public Booking bookClass(BookingRequest bookingRequest) {
        GymClass gymClass = gymClassRepository.findById(bookingRequest.getClassId())
                .orElseThrow(() -> new EntityNotFoundException("Class Not Found"));

        if(gymClass.getCapacity()<=0){
            throw new IllegalArgumentException("Class is full.");
        }
        if(bookingRequest.getParticipationDate().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Participation date must be in future.");
        }

        return new Booking();
    }

    public List<Booking> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        if (memberName == null && startDate == null && endDate == null) {
            return bookingRepository.findAll();
        }
        if (memberName != null && startDate != null && endDate != null) {
            return bookingRepository.findByMemberNameAndParticipationDateBetween(
                    memberName, startDate, endDate);
        } else if (memberName != null) {
            return bookingRepository.findByMemberName(memberName);
        } else if (startDate != null && endDate != null) {
            return bookingRepository.findByParticipationDateBetween(startDate, endDate);
        }
        return Collections.emptyList();
    }
}
