package com.zigzag.ch1.ioc.service.impl;

import com.zigzag.ch1.ioc.dao.UserDao;
import com.zigzag.ch1.ioc.service.UserService;

/**
 * @author qlk
 */
public class UserServiceImpl implements UserService {

    @Override
    public void setUserDao(UserDao userDao) {
        System.out.println("userDao = " + userDao);
    }
}
