package com.technicalTest.technicaltest.service;

import com.technicalTest.technicaltest.entity.PaymentCategory;

import java.util.List;

public interface PaymentCategoryService {

    PaymentCategory create(PaymentCategory paymentCategory);

    List<PaymentCategory> getAll();
}
