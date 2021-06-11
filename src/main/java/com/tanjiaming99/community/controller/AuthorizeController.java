package com.tanjiaming99.community.controller;

import com.tanjiaming99.community.dto.AccessTokenDTO;
import com.tanjiaming99.community.dto.GithubUser;
import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.model.User;
import com.tanjiaming99.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 19:16
 **/
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           // session是在request中拿到的
                           HttpServletRequest request,
                           // cookie在response中，是服务器给客户的，以后客户再过来就能识别到它了
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
//        accessTokenDTO.setRedirect_uri("http://community.tanjiaming99.com");
        /**
         *  拿到了！！！看信息嘛！它说要和注册的那个redirect_url一样嘛
         */
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            // 存到数据库
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            System.out.println(user);
            userMapper.insertUser(user);
            // 把这个token加入到cookie中
            response.addCookie(new Cookie("token", token));
            // 登录成功，写cookie和session
            request.getSession().setAttribute("githubUser", githubUser);
            // 重定向回首页
            return "redirect:/";
        } else {
            // 登录失败，重新登录
            return "redirect:/";
        }
    }
}
