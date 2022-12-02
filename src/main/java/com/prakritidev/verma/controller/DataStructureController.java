package com.prakritidev.verma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prakritidev.verma.response.ResposeBody;
import com.prakritidev.verma.services.DynamicProgrammingService;
import lombok.SneakyThrows;
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

    @Autowired
    ObjectMapper objectMapper;

    @SneakyThrows
    @GetMapping(value = "/recursive/fibonacci", produces = "application/json")
    public ResponseEntity<?> getFibonacciRecursive(@RequestParam("range") Integer range){
        ResposeBody response = dynamicProgrammingService.getFirstNFibonacciRecusive(range);
        return new ResponseEntity<>(objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(response), HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping(value= "/dp/fibonacci", produces = "application/json")
    public ResponseEntity<?> getFibonacciDynamicProgramming(@RequestParam("range") Integer range){
        ResposeBody response = dynamicProgrammingService.getFirstNFibonacciRecusive(range);
        return new ResponseEntity<>(objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(response), HttpStatus.OK);
    }

}
