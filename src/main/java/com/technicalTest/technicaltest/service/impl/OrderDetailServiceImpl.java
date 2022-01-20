package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.OrderDetails;
import com.technicalTest.technicaltest.repository.OrderDetailRepository;
import com.technicalTest.technicaltest.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetails create(OrderDetails orderDetails) {
        return orderDetailRepository.save(orderDetails);
    }
}
