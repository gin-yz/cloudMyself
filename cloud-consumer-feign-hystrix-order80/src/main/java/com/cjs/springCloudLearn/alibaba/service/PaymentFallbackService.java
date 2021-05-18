//用于处理feign接口调用产生的各种异常,比如服务器宕机
//若在Controller方法中还配了@HystrixCommand处理各种异常，则优先调用此页面的方法，不调用@HystrixCommand配置的方法
package com.cjs.springCloudLearn.alibaba.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystirxService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "服务-------paymentCircuitBreaker调用Fallback";
    }
}
