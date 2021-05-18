package com.cjs.springCloudLearn.alibaba.service;

import com.cjs.springCloudLearn.alibaba.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
