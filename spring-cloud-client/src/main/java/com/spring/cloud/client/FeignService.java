package com.spring.cloud.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhang_tao6 on 2017-08-16.
 */
@FeignClient("cloud-server")
public interface FeignService {

    @RequestMapping("/test")
    public String test();

    @Component
    static class HystrixClientFallback implements FeignService {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);


        public String test() {
            System.err.println("异常发生，进入fallback方法");
            return "fallback";
        }
    }

}
