package com.motan;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhang_tao6 on 2017-09-12.
 */
@SpringBootApplication
@ImportResource("classpath*:motan_*.xml")
public class MotanAppServer {
    public static void main(String[] args) {
        SpringApplication.run(MotanAppServer.class, args);
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
//        config.setAddress("10.20.42.231:2181");
//        return config;
//    }
//
//
//    @Bean(name="baseServiceConfig")
//    public BasicServiceConfigBean baseServiceConfig() {
//        BasicServiceConfigBean config = new BasicServiceConfigBean();
//        config.setExport("motan:8081");
//        config.setGroup("motan-demo-rpc");
//        config.setAccessLog(false);
//        config.setShareChannel(true);
//        config.setModule("motan-demo-rpc");
//        config.setApplication("MotanServer");
//        config.setRegistry("registryConfig");
//        return config;
//    }

}
