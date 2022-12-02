package com.prakritidev.verma.utils;

import com.prakritidev.verma.response.ResposeBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DynamicProgrammingUtils {
    private Logger logger = LoggerFactory.getLogger(DynamicProgrammingUtils.class);

    public ResposeBody prepareResponse(int statusCode, String runtime, Map<String, Object> data){
        ResposeBody resposeBody = new ResposeBody();
        resposeBody.setStatus(statusCode);
        resposeBody.setProcessTime(runtime);
        resposeBody.setData(data);
        return resposeBody;
    }

    public int calculateFibonacci(int range, List<Integer> placeholder){
        if (range <= 0) {
            placeholder.add(0);
            return 0;

        } else if (range == 1) {
            placeholder.add(1);
            return 1;
        } else {
            Integer third = calculateFibonacci(range - 1, placeholder) + calculateFibonacci(range - 2, placeholder);
            placeholder.add(third);
            return third;
        }
    }
}
