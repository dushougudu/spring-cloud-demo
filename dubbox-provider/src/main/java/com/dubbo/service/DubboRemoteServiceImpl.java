package com.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;

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
