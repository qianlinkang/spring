package com.zigzag.ioc.dao.impl;

import com.zigzag.ioc.dao.UserDao;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * @author qlk
 */
public class UserDaoImpl implements UserDao, InitializingBean {

    private String name;

    public UserDaoImpl() {
        System.out.println("UserDaoImpl无参构造器方法");
    }

    public UserDaoImpl(String name) {
        System.out.println("UserDaoImpl有参构造器方法");
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init初始化方法");
    }

    public void destroy() {
        System.out.println("销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行时机早于 init-method,afterPropertiesSet:属性注入后执行");
    }

    // 对应set方法,为strList注入值
    public void setStrList(List<String> strList) {
        strList.forEach(System.out::println);
    }

    @Override
    public void showTimeLog() {
        System.out.println("show方法执行");
    }
}
