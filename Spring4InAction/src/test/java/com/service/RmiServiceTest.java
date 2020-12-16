package com.service;

import com.config.ApplicationContextConfig;
import com.config.RMIConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : chencf-a
 * @date : 2020/11/24 17:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class,RMIConfig.class})
public class RmiServiceTest {
    @Autowired
    private RMIService rmiService;

    @Test
    public void getRmiMessage(){
        System.out.println(rmiService.getMessageByRMI("aaaaa"));
    }
}