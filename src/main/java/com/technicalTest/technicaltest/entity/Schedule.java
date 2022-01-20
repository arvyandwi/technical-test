package com.technicalTest.technicaltest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mst_schedule")
public class Schedule {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Temporal(value = TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @JsonFormat(pattern="kk:mm")
    @Column(name = "time_start")
    private LocalTime timeStart;

    @JsonFormat(pattern="kk:mm")
    @Column(name = "time_end")
    private LocalTime timeEnd;

    @CreatedDate
    @Column(updatable = false)
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @PrePersist
    private void createdDate(){
        if(this.createdAt == null) this.createdAt = new Date();
        if(this.updatedAt == null) this.updatedAt = new Date();
        this.timeEnd = this.timeStart.plusHours(1);
    }

    @PreUpdate
    private void updatedDate(){
        this.updatedAt = new Date();
        this.timeEnd = this.timeStart.plusHours(1);
    }
}
