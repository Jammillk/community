package com.tanjiaming99.community.controller;

import com.tanjiaming99.community.dto.PaginationDTO;
import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.model.User;
import com.tanjiaming99.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/14 13:10
 **/
@Controller
public class ProfileController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "3") Integer size,
                          Model model) {
        // response是从服务器返回一个cookie给浏览器，那里可以set
        // 但是想要拿到cookie，则是需要在request中拿到，就是“下次请求带过来的”
        User user = (User) request.getSession().getAttribute("user");

        if (user == null){
            return "redirect:/";
        }
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", paginationDTO);

        return "profile";
    }


}
