package com.xzit.controller;

import com.xzit.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    // 普通参数
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name,int age) {
        System.out.println("普通参数传递 name ==> "+name);
        System.out.println("普通参数传递 age ==> "+age);
        return "{'module':'common param'}";
    }

    // 普通参数：请求参数名与形参名不同
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName, int age) {
        System.out.println("普通参数传递 userName ==> "+userName);
        System.out.println("普通参数传递 age ==> "+age);
        return "{'module':'common param different name'}";
    }

    // POJO参数：json格式
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("普通参数传递 user ==> "+user);
        return "{'module':'pojo param'}";
    }

    // 嵌入POJO参数
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user) {
        System.out.println("pojo嵌入pojo参数传递 user ==> "+user);
        return "{'module':'array param'}";
    }

    // 数组参数
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==> "+ Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    // 集合参数：Json格式
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("数组参数传递 likes ==> "+ likes);
        return "{'module':'list param'}";
    }

    // 集合参数：Json格式
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody(required = false) List<String> likes){
        // 兼容：如果没传JSON数据，赋值为空集合，避免空指针
        if (likes == null) {
            likes = new ArrayList<>();
        }
        System.out.println("list common(json)参数传递 list ==> "+ likes);
        return "{'module':'list common for json param'}";
    }

    // POJO参数：Json格式
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String projoParamForJson(@RequestBody User user){
        System.out.println("pojo(json)参数传递"+user);
        return "{'module':'pojo for json param'}";
    }

    // 集合参数：json格式
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listProjoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 list ==> "+list);
        return "{'module':'list pojo for json param'}";
    }

    // 日期参数
    @RequestMapping("/dataParam")
    @ResponseBody
    public String dataParam(Date date1,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date2){
        System.out.println("参数传递 date1 ==> "+date1);
        System.out.println("参数传递 date2(yyyy-MM-dd) ==> "+date2);
        return "{'module':'data param'}";
    }
}
