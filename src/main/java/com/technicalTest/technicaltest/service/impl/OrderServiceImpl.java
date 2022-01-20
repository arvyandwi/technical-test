package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.Order;
import com.technicalTest.technicaltest.repository.OrderRepository;
import com.technicalTest.technicaltest.service.OrderDetailService;
import com.technicalTest.technicaltest.service.OrderService;
import com.technicalTest.technicaltest.service.VenueDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    VenueDetailService venueDetailService;

    @Autowired
    OrderDetailService orderDetailService;

    @Override
    public Order create(Order order) {
        Order save = orderRepository.save(order);

        BigDecimal sum = new BigDecimal(0);
        save.setTotalPrice(sum);
        return save;
    }
}
