package com.prakritidev.verma.controller;

import com.prakritidev.verma.services.CreationalPatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreationPatternsController {

    @Autowired
    CreationalPatterService creationalPatterService;


    /**
     * Factory Pattern
     * @param message
     * @param channel
     * @return
     */
    @GetMapping(value= "/design-patterns/factory-method", produces = "application/json")
    public ResponseEntity<?> sendNotificationServerice(@RequestParam(value = "message") String message, @RequestParam(value ="channel") String channel){
        return new ResponseEntity<>(creationalPatterService.abstractPatterNotificationFactory(message, channel), HttpStatus.OK);
    }
    // TODO: implement Abstract Factory Patter API

    @GetMapping(value= "/design-patterns/builder-method", produces = "application/json")
    public ResponseEntity<?> createUserDefinedCustomShit(@RequestParam(value = "message") String message, @RequestParam(value ="channel") String channel){
        return new ResponseEntity<>(creationalPatterService.abstractPatterNotificationFactory(message, channel), HttpStatus.OK);
    }



}
