package com.cjs.springCloudLearn.alibaba.loadBalanceSelf;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    //做成bean每次调用直接轮询返回的服务器
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
