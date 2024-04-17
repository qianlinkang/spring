package com.zigzag.ch1.test01;

/**
 * @author qlk
 */
public class UserServiceImpl implements UserService {

    @Override
    public void setUserDao(UserDao userDao) {
        System.out.println("userDao = " + userDao);
    }
}
