package com.motan;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhang_tao6 on 2017-09-13.
 */
@SpringBootApplication
@ImportResource("classpath*:motan_*.xml")
public class MotanAppClient {
    public static void main(String[] args) {
        SpringApplication.run(MotanAppClient.class, args);
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("server start...");
    }


//    @Bean(name = "motan")
//    public ProtocolConfigBean protocolConfig() {
//        ProtocolConfigBean config = new ProtocolConfigBean();
//        config.setName("motan");
//        config.setMaxContentLength(1048576);
//        return config;
//    }
//
//    @Bean(name = "registryConfig")
//    public RegistryConfigBean registryConfig() {
//        RegistryConfigBean config = new RegistryConfigBean();
//        config.setRegProtocol("zookeeper");
//        config.setAddress("10.20.42.230:2181");
//        return config;
//    }
//
//
//    @Bean(name = "basicRefererConfig")
//    public BasicRefererConfigBean baseRefererConfig() {
//        BasicRefererConfigBean config = new BasicRefererConfigBean();
//        config.setProtocol("motan");
//        config.setGroup("motan-demo-rpc");
//        config.setModule("motan-demo-rpc");
//        config.setApplication("MotanClient");
//        config.setRegistry("registryConfig");
//        config.setCheck(false);
//        config.setAccessLog(true);
//        config.setRetries(2);
//        config.setThrowException(true);
//        return config;
//    }

}
