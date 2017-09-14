package com.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhang_tao6 on 2017-09-14.
 */
@SpringBootApplication
@ImportResource("classpath*:dubbo-*.xml")
public class DubboAppClient {
    public static void main(String[] args) {
        SpringApplication.run(DubboAppClient.class, args);
    }
}
