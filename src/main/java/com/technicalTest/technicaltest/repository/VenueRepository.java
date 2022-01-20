package com.technicalTest.technicaltest.repository;

import com.technicalTest.technicaltest.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VenueRepository extends JpaRepository<Venue, String> {

    @Query(value = "Select f FROM Facility f WHERE f.isDeleted = false")
    List<Venue> getActiveVenue();
}
