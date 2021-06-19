package com.tanjiaming99.community.exception;

import lombok.Data;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 15:59
 **/
@Data
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

}
