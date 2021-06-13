package com.tanjiaming99.community.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/11 22:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
    private Integer id;
    private String title;
    private String description;
    private  String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}
