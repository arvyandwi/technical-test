package com.technicalTest.technicaltest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.technicalTest.technicaltest.entity.Venue;
import com.technicalTest.technicaltest.response.WebResponse;
import com.technicalTest.technicaltest.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public ResponseEntity<WebResponse<Venue>> createVenue(@RequestBody Venue request)
            throws JsonProcessingException {
        Venue venue = venueService.create(request);
        WebResponse<Venue> response = new WebResponse<>("Facility created successfully", venue);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<Venue>>> getActiveVenues() {
        List<Venue> venues = venueService.getAllActiveVenues();
        WebResponse<List<Venue>> response = new WebResponse<>("Fetched All Active Venues", venues);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
