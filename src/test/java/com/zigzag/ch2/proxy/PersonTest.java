package com.zigzag.ch2.proxy;


import com.zigzag.ch2.proxy.satic.demo1.Father;
import com.zigzag.ch2.proxy.satic.demo1.Son;
import org.junit.Test;

/**
 * @author qlk
 */
public class PersonTest {

    @Test
    public void findLove() {
        Father father = new Father(new Son());
        father.findLove();
    }
}