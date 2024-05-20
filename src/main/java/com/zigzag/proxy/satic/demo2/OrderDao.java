package com.zigzag.proxy.satic.demo2;

/**
 * @author qlk
 */
public class OrderDao {
    public int insert(Order order) {
        System.out.println("OrderDao创建订单成功");
        return 1;
    }
}
