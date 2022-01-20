package com.technicalTest.technicaltest.controller;

import com.technicalTest.technicaltest.entity.VenueDetails;
import com.technicalTest.technicaltest.response.WebResponse;
import com.technicalTest.technicaltest.service.VenueDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venue-details")
public class VenueDetailController {

    @Autowired
    private VenueDetailService venueDetailService;

    @PostMapping
    public ResponseEntity<WebResponse<VenueDetails>> createDetail(@RequestBody VenueDetails request){
        VenueDetails details = venueDetailService.create(request);
        WebResponse<VenueDetails> response = new WebResponse<>("Facility detail added", details);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<VenueDetails>>> getAll() {
        List<VenueDetails> details = venueDetailService.getAll();
        WebResponse<List<VenueDetails>> response = new WebResponse<>("Fetched All Venue Details", details);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
