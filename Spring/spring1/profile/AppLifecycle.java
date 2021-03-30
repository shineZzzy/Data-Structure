package org.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLifecycle {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
        ((ClassPathXmlApplicationContext) context).close();
    }
}