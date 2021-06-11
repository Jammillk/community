package com.tanjiaming99.community.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/11 13:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;



}
