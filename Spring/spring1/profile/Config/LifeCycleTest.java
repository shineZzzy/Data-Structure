package org.profile.Config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleTest implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware, BeanFactoryAware {

    public void beanInit(){
        System.out.println("init-method: 注解是使用@Bean(initMethod=\"方法名\")的方式，xml是使用<bean init-method=\"方法名\" />");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    public void beanDestroy(){
        System.out.println("destroy-method: 注解是使用@Bean(destroyMethod=\"方法名\")的方式，xml是使用<bean destroy-method=\"方法名\" />");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }
}