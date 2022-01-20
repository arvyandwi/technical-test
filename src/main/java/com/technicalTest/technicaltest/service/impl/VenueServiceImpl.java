package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.Venue;
import com.technicalTest.technicaltest.repository.VenueRepository;
import com.technicalTest.technicaltest.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public Venue create(Venue venue) {
        return venueRepository.save(venue);
    }

    @Override
    public List<Venue> getAllActiveVenues() {
        return venueRepository.getActiveVenue();
    }
}
