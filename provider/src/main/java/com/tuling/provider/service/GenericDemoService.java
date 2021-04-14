package com.tuling.provider.service;

import com.tuling.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
//暴露出去的的是DemoService，消费者如果消费DemoService，则会消费这个服务
//@Service(interfaceName = "com.tuling.DemoService", version = "generic")
public class GenericDemoService implements GenericService {
    @Override
    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        System.out.println("执行了generic服务");

        return "执行的方法是" + s;
    }
}
