package com.technicalTest.technicaltest.service;

import com.technicalTest.technicaltest.entity.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    Schedule create(Schedule schedule);

    List<Schedule> getAll();

    List<Schedule> getAllTimesFromDate(Date date);
}
