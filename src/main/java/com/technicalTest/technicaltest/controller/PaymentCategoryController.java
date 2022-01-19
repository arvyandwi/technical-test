package com.technicalTest.technicaltest.controller;

import com.technicalTest.technicaltest.entity.PaymentCategory;
import com.technicalTest.technicaltest.response.WebResponse;
import com.technicalTest.technicaltest.service.PaymentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-category")
public class PaymentCategoryController {

    @Autowired
    private PaymentCategoryService paymentCategoryService;

    @PostMapping
    public ResponseEntity<WebResponse<PaymentCategory>> create(@RequestBody PaymentCategory request) {
        PaymentCategory category = paymentCategoryService.create(request);
        WebResponse<PaymentCategory> response = new WebResponse<>("Successfully Created Payment Category", category);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<PaymentCategory>>> getAll() {
        List<PaymentCategory> categories = paymentCategoryService.getAll();
        WebResponse<List<PaymentCategory>> response = new WebResponse<>("Fetched All Payment Categories", categories);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
