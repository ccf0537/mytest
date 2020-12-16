package com.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : chencf-a
 * @date : 2020/11/27 16:41
 */
@Component
public class MessageService {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        jmsTemplate.convertAndSend(message);
    }

    public void sendRabbitMessage(String message){
        MessageProperties messageProperties;
        Message amqpMessage = new Message(message.getBytes(), new MessageProperties());
        rabbitTemplate.send("fanout.exchange","routingKey1",amqpMessage);
        System.out.println("send message by rabbitTemplate");
    }

    public Object reciveMessage(){
        //jmsTemplate的recice和receiveAndConvert方法接收消息是同步的，如果队列没有消息，程序会一直等待，阻塞程序的执行。
        Object message = jmsTemplate.receiveAndConvert();
        System.out.println("recive message:"+message);
        return message;
    }

    public String reciveRabbitMessage(){
        Message message = rabbitTemplate.receive("rabbit.queue1");
        System.out.println(new String(message.getBody()));
        return message.toString();

    }
    public void handlerMessage(String message){
        System.out.println("MDP handler message: "+message);
    }
}
