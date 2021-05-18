package com.cjs.springCloudLearn.alibaba.service.impl;

import com.cjs.springCloudLearn.alibaba.dao.PaymentDao;
import com.cjs.springCloudLearn.alibaba.entities.Payment;
import com.cjs.springCloudLearn.alibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    //还可以用@Resource，是java自带的依赖注入，@Autowired是spring自带的
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
