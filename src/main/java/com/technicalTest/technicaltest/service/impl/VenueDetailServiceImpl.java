package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.VenueDetails;
import com.technicalTest.technicaltest.repository.VenueDetailRepository;
import com.technicalTest.technicaltest.service.VenueDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueDetailServiceImpl implements VenueDetailService {

    @Autowired
    private VenueDetailRepository venueDetailRepository;

    @Override
    public VenueDetails create(VenueDetails venueDetails) {
        return venueDetailRepository.save(venueDetails);
    }

    @Override
    public List<VenueDetails> getAll() {
        return venueDetailRepository.findAll();
    }
}
