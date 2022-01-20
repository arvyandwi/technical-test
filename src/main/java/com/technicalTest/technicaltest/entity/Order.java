package com.technicalTest.technicaltest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tr_order")
public class Order {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreatedDate
    @Column(name = "order_date")
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime orderDate;

    @Column(name ="order_due")
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime orderDue;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "order_status")
    private Integer orderStatus;

    @OneToMany(targetEntity = OrderDetails.class, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<OrderDetails> orderDetails;

    @PrePersist
    private void createdDate(){
        if(this.orderDate == null) this.orderDate = LocalDateTime.now();
        if(this.orderStatus == null) this.orderStatus = 0;
        this.orderDue = orderDate.plusHours(1);
    }
}
