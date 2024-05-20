package com.zigzag.ioc;

import com.zigzag.ioc.service.UserService;
import com.zigzag.ioc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author qlk
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建xml读取器
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        // 加载xml文件
        xmlReader.loadBeanDefinitions("beans.xml");
        // 获取bean
        UserService userService = (UserServiceImpl) beanFactory.getBean("userService");

        System.out.println("userService = " + userService);

        //userDao = com.zigzag.ch1.test01.UserDaoImpl@42d3bd8b
        //userService = com.zigzag.ch1.test01.UserServiceImpl@26ba2a48
    }

}
