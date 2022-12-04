package com.prakritidev.verma.services;

import com.prakritidev.verma.response.ResposeBody;
import com.prakritidev.verma.utils.DynamicProgrammingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DynamicProgrammingService {
    private Logger logger = LoggerFactory.getLogger(DynamicProgrammingService.class);

    @Autowired
    DynamicProgrammingUtils utils;

    /**
     * Implementation of Fibonacci Number
     */

    public ResposeBody getFirstNFibonacciRecusive(int range) {
        long start = System.currentTimeMillis();
        List<Integer> response = new ArrayList<>();
        try {
            int first = 0;
            int second = 1;
            response.add(first);
            response.add(second);
            for (int i = 0; i <= range; i++) {
                int third = first + second;
                first = second;
                second = third;
                response.add(third);
            }
        } catch (Exception e){
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            return utils.prepareResponse(500, sec + " milliseconds", Map.of("data", e.getStackTrace()));
        }

        long end = System.currentTimeMillis();
        float sec = (end - start);
        return utils.prepareResponse(200, sec + " milliseconds", Map.of("data", response));

    }

    public ResposeBody getFirstNFibonacciDP(int range) {
        long start = System.currentTimeMillis();
        try {

        } catch (Exception e){
            long end = System.currentTimeMillis();
            float sec = (end - start);
            return utils.prepareResponse(500, sec + " milliseconds", Map.of("data", e.getStackTrace()));
        }

        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        return utils.prepareResponse(200, sec + " seconds", Map.of("data", "data"));

    }

    



}
