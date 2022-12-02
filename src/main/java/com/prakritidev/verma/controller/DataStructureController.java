package com.prakritidev.verma.controller;

import com.prakritidev.verma.response.ResposeBody;
import com.prakritidev.verma.services.DynamicProgrammingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataStructureController {

    @Autowired
    DynamicProgrammingService dynamicProgrammingService;

    @GetMapping("/recursive/fibonacci")
    public ResponseEntity<?> getFibonacciRecursive(@RequestParam("range") Integer range){
        ResposeBody response = dynamicProgrammingService.getFirstNFibonacciRecusive(range);
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

    @GetMapping("/dp/fibonacci")
    public ResponseEntity<?> getFibonacciDynamicProgramming(@RequestParam("range") Integer range){
        ResposeBody response = dynamicProgrammingService.getFirstNFibonacciRecusive(range);
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

}
