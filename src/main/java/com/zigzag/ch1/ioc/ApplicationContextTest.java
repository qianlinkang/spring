package com.zigzag.ch1.ioc;

import com.zigzag.ch1.ioc.dao.UserDao;
import com.zigzag.ch1.ioc.dao.impl.UserDaoImpl;
import com.zigzag.ch1.ioc.service.UserService;
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


//        UserDao userDao = (UserDao) context.getBean("userDao");
//        System.out.println("userDao = " + userDao);


//        PersonDao personDao = (PersonDao) context.getBean("personDao");
//        System.out.println("personDao = " + personDao);

//        PersonDao personDao = (PersonDao) context.getBean("personDao2");
//        System.out.println("personDao2 = " + personDao);

//        TestBean testBean = (TestBean) context.getBean("TestBean");
//        System.out.println("testBean = " + testBean);

//        UserDaoImpl bean = context.getBean(UserDaoImpl.class);
//        System.out.println("bean = " + bean);

//        UserDao userDao = (UserDao) context.getBean("userDao");
//        userDao.showTimeLog();

        UserService userService = (UserService) context.getBean("userService");
        System.out.println("userService = " + userService);
    }
}
