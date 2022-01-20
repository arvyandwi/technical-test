package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.Schedule;
import com.technicalTest.technicaltest.exception.BadRequestException;
import com.technicalTest.technicaltest.repository.ScheduleRepository;
import com.technicalTest.technicaltest.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule create(Schedule schedule) {
        validateTime(schedule);
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getAllTimesFromDate(Date date) {
        return scheduleRepository.getAllFromDate(date);
    }

    private void validateTime(Schedule schedule){
        if(schedule.getTimeStart().isAfter(LocalTime.of(22,0))){
            throw new BadRequestException("timeStart cannot exceed 22");
        }
        List<Schedule> schedules = getAllTimesFromDate(schedule.getDate());
        for(Schedule schedule1 : schedules){
            if(schedule1.getTimeStart() == schedule.getTimeStart()){
                throw new BadRequestException("Duplicate time found");
            }
        }
    }
}
