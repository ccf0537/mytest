package com.service;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

/**
 * @author : chencf-a
 * @date : 2020/11/30 15:12
 */
@Component
public class RIMServiceImpl implements RMIService {
    @Override
    public String getMessageByRMI(String param) {
        String message = "MessageByRMI "+ param;
        return message;
    }

}
