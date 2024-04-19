package com.zigzag.ch1.ioc.processor;

import com.zigzag.ch1.ioc.dao.impl.UserDaoImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 自定义bean后处理器
 *
 * @author qlk
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 参数： bean是当前被实例化的Bean，beanName是当前Bean实例在容器中的名称
     * 返回值：当前Bean实例对象
     * <p></p>
     * 属性注入完成,初始化方法之前
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserDaoImpl) {
            UserDaoImpl userDao = (UserDaoImpl) bean;
            userDao.setName("好好");
        }
        System.out.println(beanName + ":postProcessBeforeInitialization");
        return bean;
    }

    /**
     * 参数： bean是当前被实例化的Bean，beanName是当前Bean实例在容器中的名称
     * 返回值：当前Bean实例对象
     * <p></p>
     * 在初始化方法执行之后
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + ":postProcessAfterInitialization");
        return bean;
    }
}
