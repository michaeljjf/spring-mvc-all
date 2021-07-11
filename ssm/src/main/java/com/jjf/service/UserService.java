package com.jjf.service;

import com.jjf.pojo.User;

public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}
