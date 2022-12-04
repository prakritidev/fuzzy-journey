package com.prakritidev.verma.implementation.impl;

import com.prakritidev.verma.implementation.NotificationAbstractPattern;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationAbstractPatternConcreteImpl implements NotificationAbstractPattern {


    /**
     * @param message 
     * @return
     */
    @Override
    public String notify(String message) {
        return "EmailNotificationAbstractPatternConcreteImpl: " + message;
    }
}
