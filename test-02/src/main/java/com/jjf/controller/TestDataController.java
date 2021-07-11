package com.jjf.controller;

import com.jjf.pojo.Person;
import com.jjf.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestDataController {

    /**
     * 紧耦合方式参数注入
     * 使用HttpServletRequest对象获取参数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getParamByRequest")
    public String getParam1(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username=" + username + " password=" +password);
        return "getParamByRequest-Success";
    }

    /**
     * 解耦合方式参数注入
     * 通过使用SpringMVC框架功能，自动转换参数
     * 处理单元参数列表中的参数名必须和请求中的参数名一致
     * @return
     */
    @RequestMapping("/getParamByArgNmae")
    public String getParam1(String username, String password) {
        System.out.println("username=" + username + " password=" +password);
        return "getParamByArgNmae-Success";
    }

    /**
     * SpringMVC通过反射机制，把参数映射到实体属性，调用属性的set方法
     * 对于Post请求中文乱码问题，通过在WEB-INF/web.xml中配置utf-8编码解决
     * @param user
     * @return
     */
    @RequestMapping("/getParamByPojo")
    public String getParamByPojo(User user) {
        System.out.println(user);
        return "getParamByPojo-success";
    }

    /**
     * List集合、Map集合接收参数
     * 传参方式见：testData.jsp
     * @param person
     * @return
     */
    @RequestMapping("/getParamByPojo2")
    public String getParamByPojo2(Person person) {
        System.out.println(person);
        return "getParamByPojo2-success";
    }
}
