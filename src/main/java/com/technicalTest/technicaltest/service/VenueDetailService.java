package com.technicalTest.technicaltest.service;

import com.technicalTest.technicaltest.entity.VenueDetails;

import java.util.List;

public interface VenueDetailService {

    VenueDetails create(VenueDetails venueDetails);

    List<VenueDetails> getAll();
}
