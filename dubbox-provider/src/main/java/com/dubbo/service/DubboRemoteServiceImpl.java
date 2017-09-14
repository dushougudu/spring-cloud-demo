package com.dubbo.service;

import org.springframework.stereotype.Service;

/**
 * Created by zhang_tao6 on 2017-09-14.
 */
@Service
public class DubboRemoteServiceImpl implements DubboRemoteService {
    public String hello(String name) {
        System.out.print("dubbo-provider: hello " + name);
        return "hello " + name;
    }
}
