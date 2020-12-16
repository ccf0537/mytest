package com.controller;

import com.service.MessageService;
import com.service.RMIService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chencf-a
 * @date : 2020/11/24 16:15
 */
@Component
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    public void getUserList(){
//        userService.remove("11111");
        System.out.println(userService.getUserName("11111"));
//        userService.getUserList();
    }
    public void sendMessage(String message){
//        messageService.sendMessage(message);
        messageService.sendRabbitMessage(message);
    }
    public void reciveMessage(){
//        messageService.reciveMessage();
        messageService.reciveRabbitMessage();
    }
}
