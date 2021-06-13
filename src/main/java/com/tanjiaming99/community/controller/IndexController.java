package com.tanjiaming99.community.controller;

import com.tanjiaming99.community.dto.QuestionDTO;
import com.tanjiaming99.community.mapper.QuestionMapper;
import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.model.Question;
import com.tanjiaming99.community.model.User;
import com.tanjiaming99.community.service.QuestionService;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 15:52
 **/
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request, Model model) {
        // response是从服务器返回一个cookie给浏览器，那里可以set
        // 但是想要拿到cookie，则是需要在request中拿到，就是“下次请求带过来的”
        Cookie[] cookies = request.getCookies();
        // 手动把cookie清除后，出现了空指针
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                // 检验登录状态
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        // 在此查询出首页发帖的media页面
        List<QuestionDTO> questionList = questionService.list();


        model.addAttribute("questions", questionList);
        return "index";
    }
}
