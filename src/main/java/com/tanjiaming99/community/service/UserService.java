package com.tanjiaming99.community.service;

import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.model.User;
import com.tanjiaming99.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/17 15:14
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            // 插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
//           userMapper.insertUser(user);
        } else {
            // 更新
            User dbUser = users.get(0);
            User updateUser = new User();
            UserExample example = new UserExample();
            updateUser.setGmtCreate(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            example.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        }
    }
}
