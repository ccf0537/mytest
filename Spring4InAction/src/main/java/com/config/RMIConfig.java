package com.config;

import com.service.RMIService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @author : chencf-a
 * @date : 2020/11/30 15:21
 */
@Configuration
public class RMIConfig {

//    @Bean
//    public RmiServiceExporter rmiServiceExporter(RMIService rmiService){
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setServiceName("myRmiService");
//        rmiServiceExporter.setService(rmiService);
//        rmiServiceExporter.setServiceInterface(rmiService.getClass());
//        return rmiServiceExporter;
//    }
//
//    @Bean
//    public RmiProxyFactoryBean rmiService(){
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/myRmiService");
//        rmiProxyFactoryBean.setServiceInterface(RMIService.class);
//        return rmiProxyFactoryBean;
//    }
}
