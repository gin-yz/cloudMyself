package com.cjs.springCloudLearn.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HysrixDashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HysrixDashBoardMain9001.class,args);
    }
}
