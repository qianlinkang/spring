package com.zigzag.ch2.proxy.satic.demo1;

/**
 * @author qlk
 */
public class Father implements Person {
    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        System.out.println("父亲帮忙物色对象");
        son.findLove();
    }
}
