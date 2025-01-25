package com.abc.gym.managent.abc_gym_management_stories_app.repo;

import com.abc.gym.managent.abc_gym_management_stories_app.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByMemberName(String memberName);
    List<Booking> findByParticipationDateBetween(LocalDate startDate, LocalDate endDate);
    List<Booking> findByMemberNameAndParticipationDateBetween(String memberName, LocalDate startDate, LocalDate endDate);
}
