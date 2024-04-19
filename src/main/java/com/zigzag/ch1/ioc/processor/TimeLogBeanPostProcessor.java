package com.zigzag.ch1.ioc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author qlk
 */
public class TimeLogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TimeLogBeanPostProcessor:postProcessAfterInitialization");

        //对Bean进行动态代理，返回的是Proxy代理对象
        Object proxyBean = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    long start = System.currentTimeMillis();
                    System.out.println("开始时间：" + new Date(start));
                    //执行目标方法
                    Object result = method.invoke(bean, args);
                    long end = System.currentTimeMillis();
                    System.out.println("结束时间：" + new Date(end));
                    return result;
                });

        //返回代理对象,注入到单例对象池
        return proxyBean;
    }
}
