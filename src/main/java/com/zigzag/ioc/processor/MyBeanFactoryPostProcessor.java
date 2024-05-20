package com.zigzag.ioc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * bean工厂后处理器
 *
 * @author qlk
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // 将ConfigurableListableBeanFactory强转成子类DefaultListableBeanFactory
        // DefaultListableBeanFactory具有往BeanDefinitionMap中存入数据的方法
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)
                    beanFactory;
            // 动态注册PersonDaoImpl,存入BeanDefinitionMap
            RootBeanDefinition beanDefinition = new RootBeanDefinition();
            beanDefinition.setBeanClassName("com.zigzag.ch1.ioc.dao.impl.PersonDaoImpl");
            defaultListableBeanFactory.registerBeanDefinition("personDao", beanDefinition);
        }
    }
}
