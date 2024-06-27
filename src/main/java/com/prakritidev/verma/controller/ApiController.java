package com.prakritidev.verma.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/input")
    public String handleInput(@RequestBody String input) {
        // Process the input
        return "Processed input: " + input;
    }
}