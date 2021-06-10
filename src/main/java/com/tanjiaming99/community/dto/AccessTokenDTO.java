package com.tanjiaming99.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 19:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * DTO是数据传输对象
 * 下面的参数都是在github中需要重定向时携带的
 */
public class AccessTokenDTO {
    /**
     * Required. The client ID you received from GitHub for your OAuth App.
     */
    private String client_id;
    /**
     * 	Required. The client secret you received from GitHub for your OAuth App.
     */
    private String client_secret;
    /**
     * Required. The code you received as a response to Step 1.
     */
    private String code;
    /**
     * The URL in your application where users are sent after authorization.
     */
    private String redirect_uri;
    /**
     * 登录时随机给的一个值
     */
    private String state;

}
