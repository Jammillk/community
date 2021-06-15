package com.tanjiaming99.community.controller;

import com.tanjiaming99.community.dto.PaginationDTO;
import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
    public String hello(HttpServletRequest request, Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "3") Integer size) {
        // 在此查询出首页发帖的media页面
        PaginationDTO pagination = questionService.list(page, size);

        model.addAttribute("pagination", pagination);
        return "index";
    }
}
