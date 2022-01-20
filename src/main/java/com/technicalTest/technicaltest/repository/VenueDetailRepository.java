package com.technicalTest.technicaltest.repository;

import com.technicalTest.technicaltest.entity.VenueDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueDetailRepository extends JpaRepository<VenueDetails, String> {
}
