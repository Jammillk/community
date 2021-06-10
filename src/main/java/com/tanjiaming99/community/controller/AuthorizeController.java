package com.tanjiaming99.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 19:16
 **/
@Controller
public class AuthorizeController {

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {

        return "index";
    }
}
