package com.tanjiaming99.community.dto;

import com.tanjiaming99.community.exception.CustomizeErrorCode;
import com.tanjiaming99.community.exception.CustomizeException;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/19 10:02
 **/
@Data
@AllArgsConstructor
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code, String message){
        return new ResultDTO(code, message);
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }
    public static ResultDTO okOf() {
        return new ResultDTO(200,"请求成功");
    }

    public static ResultDTO errorOf(CustomizeException e){
        return errorOf(e.getCode(), e.getMessage());
    }

}
