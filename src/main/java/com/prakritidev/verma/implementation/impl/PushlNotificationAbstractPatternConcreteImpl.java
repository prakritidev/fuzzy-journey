package com.prakritidev.verma.implementation.impl;

import com.prakritidev.verma.implementation.NotificationAbstractPattern;

public class PushlNotificationAbstractPatternConcreteImpl implements NotificationAbstractPattern {
    /**
     * @param message 
     * @return
     */
    @Override
    public String notify(String message) {
        return "PushlNotificationAbstractPatternConcreteImpl: " + message;
    }
}
