package com.spring.cloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloControler {

    @Autowired
    RemoteService remoteService;

    @Autowired
    FeignService feignService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/remoteTest")
    public String remoteTest() {
        return remoteService.test();
    }

    @RequestMapping("/feignTest")
    public String feignTest() {
        return feignService.test();
    }

    @RequestMapping("/discovery")
    public String doDiscoveryService() {
        StringBuilder buf = new StringBuilder();
        List<String> serviceIds = discoveryClient.getServices();
        if (!CollectionUtils.isEmpty(serviceIds)) {
            for (String s : serviceIds) {
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
                if (!CollectionUtils.isEmpty(serviceInstances)) {
                    for (ServiceInstance si : serviceInstances) {
                        buf.append("[" + si.getServiceId() + " host=" + si.getHost() + " port=" + si.getPort() + " uri=" + si.getUri() + "]");
                    }
                } else {
                    buf.append("no service.");
                }
            }
        }
        return buf.toString();
    }

    @Value("${mysqldb.datasource.url}")
    String mysqlUrl;

    @RequestMapping("/config")
    public String config() {
        return "mysqlUrl:" + mysqlUrl;
    }
}
