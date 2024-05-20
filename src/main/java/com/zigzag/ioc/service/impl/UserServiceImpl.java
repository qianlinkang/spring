package com.zigzag.ioc.service.impl;

import com.zigzag.ioc.dao.UserDao;
import com.zigzag.ioc.service.UserService;

/**
 * @author qlk
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl无参构造器方法");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("UserServiceImpl执行注入userDao: setUserDao()");
    }
}
