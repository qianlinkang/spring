package com.zigzag.ch2.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qlk
 */
public class ProxyDemo {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class[]{Person.class},
                handler);

        person.walk();
        person.sayHello("孙悟空");
    }
}


interface Person {
    void walk();

    void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法: " + method);
        if (args != null) {
            System.out.println("传递的实参:");
            for (Object arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("没有实参");
        }
        return null;
    }
}