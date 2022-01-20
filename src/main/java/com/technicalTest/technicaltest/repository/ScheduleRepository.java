package com.technicalTest.technicaltest.repository;

import com.technicalTest.technicaltest.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    @Query(value = "SELECT s from Schedule s WHERE s.date = ?1")
    List<Schedule> getAllFromDate(Date date);
}
