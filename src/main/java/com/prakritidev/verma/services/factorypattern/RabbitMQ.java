package com.prakritidev.verma.services.factorypattern;

public class RabbitMQ implements NotificationService {

    @Override
    public String sendNotification(String message) {
        System.out.println("Sending Message through RabbitMQ: " + message);
        return "Message sent through RabbitMQ: " + message;
    }
    
}
