package com.cjs.springCloudLearn.controller;

import com.cjs.springCloudLearn.entities.CommonResult;
import com.cjs.springCloudLearn.entities.Payment;
import com.cjs.springCloudLearn.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        //接收json时，要加上@RequestBody,如果是表单，则不加。
        //result为插入的数量，自增的id存放在payment中
        int result = paymentService.create(payment);
        log.info("创建返回值为：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else return new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(444, "没有对应记录,查询ID: " + id, null);
        }
    }
}
