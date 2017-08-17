package com.spring.cloud.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteService {

    final String SERVICE_NAME="cloud-server";

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String test() {
        return restTemplate.getForObject("http://"+SERVICE_NAME+"/test", String.class);
    }

    private String fallback() {
        System.err.println("异常发生，进入fallback方法");
        return "fallback";
    }

}
