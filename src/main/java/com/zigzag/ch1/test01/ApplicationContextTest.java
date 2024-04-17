package com.zigzag.ch1.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qlk
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        UserService userService = (UserService) context.getBean("userService");
//        UserService userService2 = (UserService) context.getBean("userService");
//        System.out.println(userService == userService2);
//        System.out.println("userService = " + userService);
//        System.out.println("userService2 = " + userService2);


        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println("userDao = " + userDao);



    }
}
