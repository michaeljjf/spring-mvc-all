package com.jjf.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AnnotationController {

    /**
     * 当传入参数与形参名称不一样时，使用@RequestParam指定,required指定是否必须提供
     *
     * @param uname
     * @param age
     * @return
     */
    @RequestMapping("/getAnnotationParam")
    public String getRequestParam(@RequestParam("name") String uname, @RequestParam(value = "age", required = true) Integer age) {
        System.out.println(uname + "," + age);
        return "getAnnotationParam-success";
    }

    /**
     * 获取restful风格中url中的参数 @PathVariable
     *
     * @param type
     * @param id
     * @return
     */
    @RequestMapping("/getPathVar/{type}/{id}")
    public String getPathVar(@PathVariable("type") String type, @PathVariable("id") Integer id) {
        System.out.println(type + "," + id);
        return "getPathVar-success";
    }

    /**
     * 获取请求头内容
     * @param accept
     * @return
     */
    @RequestMapping("getRequestHeader")
    public String getRequestHeader(@RequestHeader(value = "Accept", required = false) String accept) {
        System.out.println(accept);
        return "getRequestHeader-success";
    }

    /**
     * 获取cookie内容
     * @param cookieValue
     * @return
     */
    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue(value = "JSESSIONID", required = false) String cookieValue) {
        System.out.println(cookieValue);
        return "getCookie-success";
    }
}
