package com.abc.gym.managent.abc_gym_management_stories_app.service;

import com.abc.gym.managent.abc_gym_management_stories_app.dto.GymClassRequestDTO;
import com.abc.gym.managent.abc_gym_management_stories_app.model.GymClass;
import com.abc.gym.managent.abc_gym_management_stories_app.repo.GymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymClassService {

    @Autowired
    GymClassRepository gymClassRepository;


    public GymClass createGymClass(GymClassRequestDTO request) {
        validateRequest(request);

        GymClass gymClass = new GymClass();
        gymClass.setName(request.getName());
        gymClass.setStartDate(request.getStartDate());
        gymClass.setEndDate(request.getEndDate());
        gymClass.setStartTime(request.getStartTime());
        gymClass.setDuration(request.getDuration());
        gymClass.setCapacity(request.getCapacity());

        return gymClassRepository.save(gymClass); // Save the class in the database
    }

    private void validateRequest(GymClassRequestDTO request) {
        if (request.getStartDate().isAfter(request.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after the end date.");
        }
    }
}
