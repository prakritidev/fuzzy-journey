package com.prakritidev.verma.services.factorypattern;

public class NotificationServiceFactory {

    public NotificationService createNotificationService(String type) {

        switch (type) {
            case "KAFKA":
                return new KafkaService();
            case "RABBITMQ":
                return new RabbitMQ();
            default:
                System.out.println("returning null");
                return null;
        }
    }
}
