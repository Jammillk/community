package com.tanjiaming99.community.dto;

import lombok.Data;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 20:33
 **/
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
