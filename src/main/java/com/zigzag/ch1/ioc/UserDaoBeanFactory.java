package com.zigzag.ch1.ioc;

import com.zigzag.ch1.ioc.dao.UserDao;
import com.zigzag.ch1.ioc.dao.impl.UserDaoImpl;
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
