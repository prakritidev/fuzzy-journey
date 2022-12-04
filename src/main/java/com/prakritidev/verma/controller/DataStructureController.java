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

import java.util.List;

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

    /**
     * 0-1 KSackProblems:
     * Given a bag of weight capacity c, and items has value v and weight w.
     * Which items should be selected to obtain maximum profit, and should not exceed the bag capacity.
     *
     * @param capacity
     * @param weight
     * @param price
     * @return
     */
//    @SneakyThrows
//    @GetMapping(value= "/dp/fibonacci", produces = "application/json")
//    public ResponseEntity<?> knapSack(@RequestParam(value = "range") Integer capacity,
//                                      @RequestParam("range") List<Integer> weight,
//                                      @RequestParam("range") List<Integer> price){
//
//        ResposeBody response = dynamicProgrammingService.getFirstNFibonacciRecusive(capacity);
//        return new ResponseEntity<>(objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(response), HttpStatus.OK);
//    }

}
