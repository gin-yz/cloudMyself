package com.cjs.springCloudLearn.controller;

import com.cjs.springCloudLearn.entities.CommonResult;
import com.cjs.springCloudLearn.entities.Payment;
import com.cjs.springCloudLearn.loadBalanceSelf.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        Object data = commonResult.getData();
        log.info("客户端返回的data是：" + data.toString());
        return commonResult;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object getDiscovery() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", Object.class);
    }

    @GetMapping("/consumer/payment/getforentity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        //对discoveryClient对测试
//        List<String> services = discoveryClient.getServices();
//        for (String service : services) {
//            List<ServiceInstance> instances = discoveryClient.getInstances(service);
//            for (ServiceInstance instance : instances) {
//                Map<String, String> metadata = instance.getMetadata();
//            }
//        }

        if (httpStatus.is2xxSuccessful() || httpStatus.is3xxRedirection()) {
            return responseEntity.getBody();
        } else return new CommonResult<>(444, "操作失败");
    }

    @GetMapping("/consumer/payment/lb")
    public CommonResult testLoadBalance(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances==null || instances.size()<=0){
            return new CommonResult(444,"服务器错误");
        }
        ServiceInstance choceService = loadBalancer.instances(instances);

        return restTemplate.getForObject(choceService.getUri()+"/payment/get/1",CommonResult.class);

    }
}
