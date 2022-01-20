package com.technicalTest.technicaltest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mst_venue")
public class Venue {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;

    private String address;

    private Boolean isDeleted;

    @CreatedDate
    @Column(updatable = false)
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @PrePersist
    private void createdDate(){
        if(this.createdAt == null) this.createdAt = new Date();
        if(this.updatedAt == null) this.updatedAt = new Date();
        if(this.isDeleted == null) this.isDeleted = false;
    }

    @PreUpdate
    private void updatedDate(){
        this.updatedAt = new Date();
    }
}
