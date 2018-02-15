package com.spring.cloud.zuul;

import feign.Logger;
import feign.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApp {


    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class, args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }


    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return  new PatternServiceRouteMapper("(?<name>.+)-(?<version>v.+$)","$(version)/$(name)");
    }

}
