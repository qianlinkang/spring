package com.zigzag.ch2.proxy.satic.demo2;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author qlk
 */
public class OrderServiceProxyTest {

    @Test
    public void test() throws ParseException {
        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse("2017/02/01");
        order.setCreateTime(date.getTime());

        OrderServiceProxy proxy = new OrderServiceProxy(new OrderServiceImpl());
        proxy.createOrder(order);
    }

}