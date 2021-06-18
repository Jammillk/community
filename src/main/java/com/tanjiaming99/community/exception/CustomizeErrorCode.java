package com.tanjiaming99.community.exception;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 16:08
 **/
public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND("您找的问题不在了，要不要换一个试试？");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
