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
@Table(name = "mst_payment_category")
public class PaymentCategory {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String categoryName;

    private String codeCategory;

    private BigDecimal fee;

    private Integer status;

    @CreatedDate
    @Column(updatable = false)
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @PrePersist
    private void createdDate() {
        if (this.createdAt == null)
            this.createdAt = new Date();
        if (this.updatedAt == null)
            this.updatedAt = new Date();
        if (this.status == null)
            this.status = 1;
    }

    @PreUpdate
    private void updatedDate() {
        this.updatedAt = new Date();
    }
}
