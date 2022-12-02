package com.prakritidev.verma.response;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResposeBody {
    public int status;
    public String processTime;
    public Map<String, Object> data;


}


