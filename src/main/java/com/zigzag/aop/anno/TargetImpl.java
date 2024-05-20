package com.zigzag.aop.anno;

import org.springframework.stereotype.Component;

/**
 * @author qlk
 */
@Component("target")
public class TargetImpl {
    public void show1() {
        System.out.println("TargetImpl show1");
    }

    public void show2() {
        System.out.println("TargetImpl show2");
    }

    public String show3() {
        System.out.println("TargetImpl show3");
        return "3";
    }

    public void throwEx() {
        int i = 1 / 0;
    }
}
