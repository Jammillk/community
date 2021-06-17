package com.tanjiaming99.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/15 15:08
 **/
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SectionInterceptor sectionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 所有请求都走这个拦截器
        registry.addInterceptor(sectionInterceptor).addPathPatterns("/**");
    }

}
