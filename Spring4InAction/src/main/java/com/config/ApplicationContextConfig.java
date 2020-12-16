package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : chencf-a
 * @date : 2020/11/24 17:02
 */
@Configuration
@ComponentScan(basePackages = "com")
@ImportResource("classpath:applicationContext.xml")
public class ApplicationContextConfig {
}
