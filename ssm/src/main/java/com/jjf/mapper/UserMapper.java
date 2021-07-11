package com.jjf.mapper;

import com.jjf.pojo.User;

public interface UserMapper {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}
