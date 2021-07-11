package com.jjf.controller;

import com.jjf.pojo.Person;
import com.jjf.pojo.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 两种方式：
 * 1、通过 @Controller + @ResponseBody 响应JSON数据
 * 2、通过 @RestController 响应JSON数据
 *
 * 需要引入jackson依赖
 */
@RestController
public class JsonController {

    /**
     * 返回JSON格式数据
     * 1 方法的返回值不在作为界面跳转依据,而直接作为返回的数据
     * 2 将方法的返回的数据自动使用ObjectMapper转换为JSON
     * @param person
     * @return
     */
    @RequestMapping("/testAjax")
    public Pet testAjax(Person person) {
        System.out.println(person);
        Pet pet = new Pet("Tom", "cat");
        return pet;
    }
}
