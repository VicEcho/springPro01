package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.example.demo.controller.HelloController.getRoles(..))")
    public void log(){
        System.out.println("vicvicvicvicvic");
    }

    @Pointcut("execution(public * com.example.demo.controller.HelloController.*(..))")
    public void log2() {
    }

    @Before("log2()")
    public void log3() {
        System.out.println("before...........");
    }

    @After("log2()")
    public void log4() {
        System.out.println("after.............");
    }
}
