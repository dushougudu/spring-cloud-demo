package com.spring.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhang_tao6 on 2017-08-16.
 */
@FeignClient(name = "cloud-server",fallback = HystrixClientFallback.class)
public interface FeignService {

    @RequestMapping("/test")
    public String test();



}
