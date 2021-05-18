//手动编码注入配置网关
package com.cjs.springCloudLearn.alibaba.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfig {

//    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //注意，这个http://localhost:9527/payment/lb路径映射到http://localhost:8001/payment/lb
        routes.route("just_route_id",
                r -> r.path("/payment/lb")
                        .uri("http://localhost:8001")).build();

        return routes.build();
    }
}
