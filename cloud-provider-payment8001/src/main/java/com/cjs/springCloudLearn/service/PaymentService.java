package com.cjs.springCloudLearn.service;

import com.cjs.springCloudLearn.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
