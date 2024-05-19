package com.zigzag.ch1.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Proxy;

/**
 * @author qlk
 */
public class MyAdviceMockAopBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        MyAdvice myAdvice = applicationContext.getBean(MyAdvice.class);
        String packageName = bean.getClass().getPackage().getName();
        if ("com.zigzag.ch1.aop.service.impl".equals(packageName)) {
            System.out.println(4);
            // 对包下的bean进行动态代理
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        myAdvice.beforeAdvice(); // aop
                        Object result = method.invoke(bean, args);
                        myAdvice.afterAdvice(); // aop
                        return result;
                    }
            );
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("aware 1");
        this.applicationContext = applicationContext;
    }
}
