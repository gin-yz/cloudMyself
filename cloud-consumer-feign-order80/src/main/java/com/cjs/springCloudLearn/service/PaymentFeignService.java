package com.cjs.springCloudLearn.service;

import com.cjs.springCloudLearn.entities.CommonResult;
import com.cjs.springCloudLearn.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    //直接把8001中controller的函数复制过来，表示发送给8001的@FeignClient("CLOUD-PAYMENT-SERVICE")下的/payment/get/{id}的函数
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //也可以包装一下，使用ResponseEntity返回
    @GetMapping(value = "/payment/get/{id}")
    ResponseEntity<CommonResult<Payment>> getPaymentByIdUseEntity(@PathVariable("id") Long id);
}
