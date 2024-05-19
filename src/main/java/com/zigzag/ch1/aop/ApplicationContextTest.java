package com.zigzag.ch1.aop;

import com.zigzag.ch1.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qlk
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        UserService bean = context.getBean(UserService.class);
        bean.show1();

//        bean.show2();
    }
}
