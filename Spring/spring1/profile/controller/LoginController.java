package org.profile.controller;

import lombok.Getter;
import org.profile.Model.User;
import org.profile.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller  //注册一个id=LoginController，属性为LoginService的对象
@Getter
public class LoginController {
    //注入service属性
    @Autowired
    private LoginService loginService;

    @Bean
    public User user1(){
        User user=new User();
        user.setUsername("a");
        user.setPassword("123");
        return user;
    }

    @Bean
    public User user2(){
        User user=new User();
        user.setUsername("b");
        user.setPassword("456");
        return user;
    }


    //容器q启动时，会先调用并执行该方法，得到返回值后，才注册到容器中

    @Bean
    public User user3(User user2){
        System.out.println(user2);
        User user=new User();
        user.setUsername("c");
        user.setPassword("789");
        return user;
    }

}
