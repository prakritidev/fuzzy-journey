package com.prakritidev.verma.utils;

import com.prakritidev.verma.response.ResposeBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

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

}
