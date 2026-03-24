package com.xzit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 定义controller
// 使用@Controller定义bean
@Controller
public class UserController {
    // 设置当前操作的访问路径
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("user save ...");
        return "{'module':'springmvc save'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println("user delete ...");
        return "{'module':'springmvc delete'}";
    }
}
