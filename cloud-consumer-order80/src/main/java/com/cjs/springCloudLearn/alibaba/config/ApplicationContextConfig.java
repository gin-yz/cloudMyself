package com.cjs.springCloudLearn.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //只有加了这个以后，才能使用负载均衡的算法去选择不同的服务器(8001,8002)，这个是客户端的负载均衡，客户端通过每个服务器传输的时延(具体算法)动态的选择服务器
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
