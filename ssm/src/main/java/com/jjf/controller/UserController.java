package com.jjf.controller;

import com.jjf.pojo.User;
import com.jjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login.do")
    public String login(User user) {
        String view = null;
        User resultUser = userService.login(user);
        if (resultUser != null) {
            view = "/success.jsp";
        } else {
            view = "/fail.jsp";
        }
        return view;
    }
}
