package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.PaymentCategory;
import com.technicalTest.technicaltest.repository.PaymentCategoryRepository;
import com.technicalTest.technicaltest.service.PaymentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentCategoryServiceImpl implements PaymentCategoryService {

    @Autowired
    private PaymentCategoryRepository paymentCategoryRepository;

    @Override
    public PaymentCategory create(PaymentCategory paymentCategory) {
        return paymentCategoryRepository.save(paymentCategory);
    }

    @Override
    public List<PaymentCategory> getAll() {
        return paymentCategoryRepository.findAll();
    }
}
