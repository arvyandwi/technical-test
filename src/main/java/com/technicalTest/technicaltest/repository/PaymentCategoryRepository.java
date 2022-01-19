package com.technicalTest.technicaltest.repository;

import com.technicalTest.technicaltest.entity.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, String> {
}
