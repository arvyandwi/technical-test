package com.technicalTest.technicaltest.service;

import com.technicalTest.technicaltest.entity.Venue;

import java.util.List;

public interface VenueService {

    Venue create(Venue venue);

    List<Venue> getAllActiveVenues();
}
