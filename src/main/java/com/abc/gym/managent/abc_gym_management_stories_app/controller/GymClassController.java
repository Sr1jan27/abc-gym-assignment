package com.abc.gym.managent.abc_gym_management_stories_app.controller;

import com.abc.gym.managent.abc_gym_management_stories_app.dto.GymClassRequestDTO;
import com.abc.gym.managent.abc_gym_management_stories_app.model.GymClass;
import com.abc.gym.managent.abc_gym_management_stories_app.service.GymClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
public class GymClassController {

    @Autowired
    GymClassService gymClassService;

    @PostMapping
    public ResponseEntity<GymClass> createGymClass(@Valid @RequestBody GymClassRequestDTO gymClassRequestDTO) {
        GymClass gymClass = gymClassService.createGymClass(gymClassRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(gymClass);
    }
}
