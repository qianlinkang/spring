package com.zigzag.ch1.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * cglib生产动态代理对象
 * @author qlk
 */
public class CglibDemo {
    public static void main(String[] args) {
        // 目标对象
        Target target = new Target();
        // 增强对象
        MyAdvice3 advice = new MyAdvice3();

        // cglib
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        // 设置回调,增强方法
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            advice.before();
            Object result = method.invoke(target, objects);
            advice.after();
            return result;
        });

        // test
        Target targetProxy = (Target) enhancer.create();
        targetProxy.show();
    }
}


class Target {
    public void show() {
        System.out.println("show...");
    }
}

class MyAdvice3 {
    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}

