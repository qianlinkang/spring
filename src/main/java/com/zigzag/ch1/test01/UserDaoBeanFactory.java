package com.zigzag.ch1.test01;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author qlk
 */
public class UserDaoBeanFactory implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
