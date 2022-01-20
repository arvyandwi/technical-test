package com.technicalTest.technicaltest.controller;

import com.technicalTest.technicaltest.entity.Schedule;
import com.technicalTest.technicaltest.response.WebResponse;
import com.technicalTest.technicaltest.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<WebResponse<Schedule>> createSchedule(@RequestBody Schedule request){
        Schedule schedule = scheduleService.create(request);
        WebResponse<Schedule> response = new WebResponse<>("Schedule created successfully", schedule);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<Schedule>>> getSchedules() {
        List<Schedule> schedules = scheduleService.getAll();
        WebResponse<List<Schedule>> response = new WebResponse<>("Fetched All Schedules", schedules);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
