package com.tanjiaming99.community.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 16:08
 **/
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "您找的问题不在了，要不要换一个试试？"),
    TARGET_PARENT_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003, "当前操作需要登录，请登录后重试！"),
    SYSTEM_ERROR(2004,"服务器冒烟了,请稍后重试吧"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "您操作的评论被吃掉了");

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode() {
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
