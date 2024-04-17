package com.zigzag.ch1.test01;

import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * @author qlk
 */
public class UserDaoImpl implements UserDao, InitializingBean {

    private String name;

    public UserDaoImpl() {
    }

    public UserDaoImpl(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("初始化方法");
    }

    public void destroy() {
        System.out.println("销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行时机早于 init-method");
    }

    public void setStrList(List<String> strList) {
        strList.forEach(System.out::println);
    }
}
