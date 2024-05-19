package com.zigzag.ch1.ioc.handlers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author qlk
 */
public class HaohaoBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws
            BeansException {
        System.out.println("自动注入HaohaoBeanPostProcessor成功");
        return bean;
    }
}