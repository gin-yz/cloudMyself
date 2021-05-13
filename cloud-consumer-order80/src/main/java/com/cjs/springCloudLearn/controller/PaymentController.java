package com.cjs.springCloudLearn.controller;

import com.cjs.springCloudLearn.entities.CommonResult;
import com.cjs.springCloudLearn.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class PaymentController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        Object data = commonResult.getData();
        log.info("客户端返回的data是："+data.toString());
        return commonResult;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object getDiscovery(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery",Object.class);
    }
}
