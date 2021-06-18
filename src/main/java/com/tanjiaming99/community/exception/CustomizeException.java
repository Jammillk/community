package com.tanjiaming99.community.exception;

import lombok.Data;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 15:59
 **/
@Data
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

}
