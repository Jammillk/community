package com.tanjiaming99.community.dto;

import com.tanjiaming99.community.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/13 15:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private  String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer Creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    /**
     * 算是一个“外键”
     * Question里面是没有这个的，它要通过Creator关联到User表的头像中
     */
    private User user;
}
