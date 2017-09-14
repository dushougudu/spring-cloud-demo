package com.motan.controller;

import com.motan.service.MotanRomoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_tao6 on 2017-09-13.
 */
@RestController
public class MotanController {

//    @MotanReferer(basicReferer = "basicRefererConfig")
    @Autowired
    MotanRomoteService service;

    @RequestMapping("/test")
    public String remoteTest(@RequestParam("name") String name) {
        System.out.print("hello "+ name);
        return service.hello(name);
    }

}
