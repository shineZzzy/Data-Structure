package org.profile;

import org.profile.Model.User;
import org.profile.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//启动类 ：加载spring配置文件
public class App {

    public static void main(String[] args) {
        //根据Spring配置文件路径创建容器：应用上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //获取对象
        LoginController loginController=(LoginController) context.getBean("loginController");
        System.out.println(loginController);
//        //获取属性
//        System.out.println(loginController.getLoginService());
//        //验证依赖注入的LoginService是否为容器中的Bean对象,从service中获取原对象与注入的==
        //单例
//        LoginService loginService = context.getBean(LoginService.class);
//        System.out.println(loginController.getLoginService().equals(loginService));

        User u1= (User) context.getBean("user1");
        System.out.println(u1);
        //按类型访问：同一类型有多个id不同的对象，不知道返回哪个就报错
        //报错信息NoUniqueBeanDefinitionException：expected single matching bean but found 2
//        User u2= context.getBean(User.class);
//        System.out.println(u2);

        User u2= (User) context.getBean("user2");
        System.out.println(u2);

//        AppConfig appConfig=context.getBean(AppConfig.class);
//        System.out.println(appConfig);
//
//        User u1= (User) context.getBean("byFactoryBean");
//        System.out.println(u1);


        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}