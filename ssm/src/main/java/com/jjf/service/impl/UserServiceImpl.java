package com.jjf.service.impl;

import com.jjf.mapper.UserMapper;
import com.jjf.pojo.User;
import com.jjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public User login(User user) {
        return userMapper.login(user);
    }
}
