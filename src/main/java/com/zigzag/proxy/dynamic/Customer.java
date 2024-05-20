package com.zigzag.proxy.dynamic;

import com.zigzag.proxy.satic.demo1.Person;

/**
 * 客户类型1
 * @author qlk
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("客户需求");
    }
}
