package com.prakritidev.verma.services.factorypattern;

public class KafkaService implements NotificationService {

    @Override
    public String sendNotification(String message) {
        System.out.println("Sending Message through KafkaService: " + message);
        return "Sending Message through KafkaService: " + message;
    }
    
}
