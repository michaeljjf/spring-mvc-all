package com.jjf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jjf")
public class MyController {

    @RequestMapping("/firstController.do")
    public String firstController() {
        System.out.println("firstController");
        return "first";
    }

    @RequestMapping(value = "/testRequest", method = RequestMethod.GET)
    public String testRequest() {
        System.out.println("testRequest");
        return "success";
    }

    @RequestMapping(value = "/testRequest2", method = RequestMethod.GET, params = "username")
    public String testRequest2() {
        System.out.println("testRequest2");
        return "success";
    }

    @RequestMapping(value = "/testRequest3", method = RequestMethod.GET, params = {"username!=root", "password"})
    public String testRequest3() {
        System.out.println("testRequest3");
        return "success";
    }

    @RequestMapping(value = "/testPathVariable/{id}/{username}")
    public String testPathVariable(@PathVariable("id") String id1, @PathVariable("username") String username) {
        System.out.println("id=" + id1);
        System.out.println("username=" + username);
        System.out.println("testPathVariable");
        return "success";
    }

}
