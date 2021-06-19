package com.tanjiaming99.community.enums;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/19 10:06
 **/
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType().equals(type)){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
