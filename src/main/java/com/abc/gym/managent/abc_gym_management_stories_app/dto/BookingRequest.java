package com.abc.gym.managent.abc_gym_management_stories_app.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingRequest {

    @NotNull(message = "Member name is required")
    private String memberName;

    @NotNull(message = "Class ID is required")
    private Long classId;

    @NotNull(message = "Participation date is required")
    @Future(message = "Participation date must be in the future")
    private LocalDate participationDate;

    // Getters and Setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public LocalDate getParticipationDate() {
        return participationDate;
    }

    public void setParticipationDate(LocalDate participationDate) {
        this.participationDate = participationDate;
    }
}
