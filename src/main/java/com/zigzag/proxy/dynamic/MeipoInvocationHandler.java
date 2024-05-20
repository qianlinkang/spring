package com.zigzag.proxy.dynamic;

import com.zigzag.proxy.satic.demo1.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象
 * @author qlk
 */
public class MeipoInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getInstance(Object target) {
      this.target = target;

        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        Person instance = (Person) new MeipoInvocationHandler().getInstance(new Customer());
        instance.findLove();
    }
}
