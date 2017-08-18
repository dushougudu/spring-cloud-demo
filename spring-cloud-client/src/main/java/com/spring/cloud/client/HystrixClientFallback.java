package com.spring.cloud.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhang_tao6 on 2017-08-17.
 */
@Component
public class HystrixClientFallback implements FeignService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

    public String test() {
        LOGGER.error("异常发生，进入fallback方法");
        return "fallback";
    }
}
