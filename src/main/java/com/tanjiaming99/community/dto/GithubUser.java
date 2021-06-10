package com.tanjiaming99.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 19:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
}
