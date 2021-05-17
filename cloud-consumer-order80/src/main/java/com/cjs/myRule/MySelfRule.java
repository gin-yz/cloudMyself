//定义轮训，还要在主启动类中加上@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration=MySelfRule.class)
package com.cjs.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }
}