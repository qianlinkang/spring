package com.zigzag.ch1.ioc.service;

import com.zigzag.ch1.ioc.dao.UserDao;

/**
 * @author qlk
 */
public interface UserService {
    public void setUserDao(UserDao userDao);
}
