package com.tuling.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@EnableAutoConfiguration
public class GenericDubboConsumerDemo {

    /**
        泛化调用，将提供者暴露出来的DemoService强转成GenericService
        利用invoke方法调用
        不用在pom中引入interface，不需要import DemoService这个类
        也能调用到DemoService
     */
    @Reference(id = "demoService", version = "default", interfaceName = "com.tuling.DemoService", generic = true)
    private GenericService genericService;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(GenericDubboConsumerDemo.class);

        GenericService genericService = (GenericService) context.getBean("demoService");

        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"周瑜"});
        System.out.println(result);


    }

}
