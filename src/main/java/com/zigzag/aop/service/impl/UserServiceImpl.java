package com.zigzag.aop.service.impl;

import com.zigzag.aop.service.UserService;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author qlk
 */
public class UserServiceImpl implements UserService, InitializingBean {

    @PostConstruct
    public void postConstruct() {
        System.out.println(2);
    }

    public void init() {
        System.out.println(4);
    }
    @Override
    public void show1() {
        System.out.println("show1");
        int i = 2 /0;
    }

    @Override
    public void show2() {
        System.out.println("show2");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(3);
    }

}
