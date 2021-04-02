package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // 注意第一个参数是当前类的类对象
        SpringApplication.run(DemoApplication.class, args);
    }
}