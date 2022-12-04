package com.prakritidev.verma.services;

import com.prakritidev.verma.implementation.NotificationAbstractPattern;
import com.prakritidev.verma.implementation.impl.EmailNotificationAbstractPatternConcreteImpl;
import com.prakritidev.verma.implementation.impl.PushlNotificationAbstractPatternConcreteImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreationalPatterService {

    private Logger logger = LoggerFactory.getLogger(CreationalPatterService.class);

    public String abstractPatterNotificationFactory(String message, String channel){
        if(channel == null || channel.isEmpty()){
            return null;
        }
        switch(channel){
            case "PUSH":
                return new PushlNotificationAbstractPatternConcreteImpl().notify(message);
            case "EMAIL":
                return new EmailNotificationAbstractPatternConcreteImpl().notify(message);
            default:
                return "Unknown channel "+channel;
        }
    }
}
