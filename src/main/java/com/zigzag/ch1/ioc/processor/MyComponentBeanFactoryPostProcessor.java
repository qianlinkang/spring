package com.zigzag.ch1.ioc.processor;

import com.zigzag.ch1.ioc.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

/**
 * @author qlk
 */
public class MyComponentBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 指定要扫描的包
        String packageName = "com.zigzag.ch1.ioc";
        // 调用工具类,扫描@MyComponent注解的类进行注册
        Map<String, Class> myComponentClassMap = BaseClassScanUtils.scanMyComponentAnnotation(packageName);
        // 遍历这个map,创建BeanDefinition对象进行注册
        myComponentClassMap.forEach((beanName, clazz) -> {
            RootBeanDefinition beanDefinition = new RootBeanDefinition();
            beanDefinition.setBeanClassName(clazz.getName());
            try {
                registry.registerBeanDefinition(beanName, beanDefinition);
            } catch (BeanDefinitionStoreException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
