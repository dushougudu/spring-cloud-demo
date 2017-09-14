package com.dubbo.controller;

import com.dubbo.service.DubboRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_tao6 on 2017-09-13.
 */
@RestController
public class DubboController {

    @Autowired
    DubboRemoteService dubboRemoteService;

    @RequestMapping("/test")
    public String remoteTest(@RequestParam("name") String name) {
        System.out.print("hello "+ name);
        return dubboRemoteService.hello(name);
    }

}
