package com.cjs.springCloudLearn.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErakaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(ErakaMain7002.class,args);
    }
}
