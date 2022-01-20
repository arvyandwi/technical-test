package com.technicalTest.technicaltest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tr_venue_details")
public class VenueDetails {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(targetEntity = Venue.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne(targetEntity = Schedule.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "queue_count")
    private Integer queueCount;

    @Column(name = "is_booked")
    private Boolean isBooked;

    @CreatedDate
    @Column(updatable = false)
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @PrePersist
    private void createdDate(){
        if(this.isBooked == null) this.isBooked = false;
        if(this.queueCount == null) this.queueCount = 0;
        if(this.createdAt == null) this.createdAt = new Date();
        if(this.updatedAt == null) this.updatedAt = new Date();
    }

    @PreUpdate
    private void updatedDate(){
        this.updatedAt = new Date();
    }
}
