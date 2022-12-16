package com.prakritidev.verma.services.factorypattern;

public class FactoryPatternMain {
    public static void main(String[] args) {
        
        NotificationServiceFactory notificationServiceFactory = new NotificationServiceFactory();
        NotificationService notificationServiceKafka = notificationServiceFactory.createNotificationService("KAFKA");
        notificationServiceKafka.sendNotification("HTTP");
        NotificationService notificationServiceRabbitMQ = notificationServiceFactory.createNotificationService("RABBITMQ");
        notificationServiceRabbitMQ.sendNotification("RABBITMQ");
    }
}
