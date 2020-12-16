package com.controller;

import com.config.ApplicationContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
@Component
public class App
{
    public static void main( String[] args )
    {
        //使用java配置类初始化spring容器，此时不需要applicationContext.xml文件的存在，此种方式可以完全不需要任何xml配置
//        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        //使用xml配置文件初始化spring容器，指定配置文件相对类路径的位置，根资源文件夹名称resources不需要写
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) applicationContext.getBean("userController");
//        userController.getUserList();
        userController.sendMessage("hello rabbit mq  "+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        userController.reciveMessage();
//        userController.reciveMessage();
    }
}
