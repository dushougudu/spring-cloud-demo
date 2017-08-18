package com.spring.cloud.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteService.class);


    final String SERVICE_NAME="cloud-server";

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String test() {
        return restTemplate.getForObject("http://"+SERVICE_NAME+"/test", String.class);
    }

    private String fallback() {
        LOGGER.error("异常发生，进入fallback方法");
        return "fallback";
    }

}
