package com.cjs.springCloudLearn.alibaba.controller;

import com.cjs.springCloudLearn.alibaba.entities.CommonResult;
import com.cjs.springCloudLearn.alibaba.entities.Payment;
import com.cjs.springCloudLearn.alibaba.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") int id) {
        log.info("id is :" + id);
        return serverPort;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        //1。
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(id);
        //2。
//        ResponseEntity<CommonResult<Payment>> entity = paymentFeignService.getPaymentByIdUseEntity(id);
//        HttpStatus statusCode = entity.getStatusCode();
//        log.info(statusCode.toString());
        return paymentById;
    }

}
