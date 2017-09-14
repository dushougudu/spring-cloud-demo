package com.motan.service;

/**
 * Created by zhang_tao6 on 2017-09-12.
 */
public class MotanRomoteServiceImpl implements MotanRomoteService {

    public String hello(String name) {
        System.out.print("motan-provider: hello " + name);
        return "hello " + name;
    }
}
