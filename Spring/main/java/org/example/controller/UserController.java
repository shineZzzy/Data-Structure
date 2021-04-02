package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user") //类的请求路径
public class UserController {
    @RequestMapping("/login")
    //该方法的请求路径：/user/login
    public String login(){
        //以请求路径作为相对路径，查找相对路径上的资源
        // /返回上一级，/index.html===ip:port/index.html
        // 不指定就默认转发，js还是在/user下访问，故访问不到
        return "redirect:/index.html";
    }
}
