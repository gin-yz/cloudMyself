package com.cjs.springCloudLearn.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    private final static String INVOKEE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/zk")
    public String getPayment(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("注册的微服务有："+service.toString());
        }
        return restTemplate.getForObject(INVOKEE_URL+"/payment/zk",String.class);
    }

}
