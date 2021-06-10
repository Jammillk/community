package com.tanjiaming99.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 15:52
 **/
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model) {

        model.addAttribute("name",name);
        return "hello";
    }
}
