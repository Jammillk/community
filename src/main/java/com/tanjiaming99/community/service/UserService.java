package com.tanjiaming99.community.service;

import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/17 15:14
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
        System.out.println("----"+user);
        User dbUser =  userMapper.findByAccountId(user.getAccountId());
       if (dbUser == null){
           // 插入
           user.setGmtCreate(System.currentTimeMillis());
           user.setGmtModified(user.getGmtCreate());
           userMapper.insertUser(user);
       }else{
           // 更新
           dbUser.setGmtModified(System.currentTimeMillis());
           dbUser.setAvatarUrl(user.getAvatarUrl());
           dbUser.setName(user.getName());
           dbUser.setToken(user.getToken());
           userMapper.update(dbUser);
       }
    }
}
