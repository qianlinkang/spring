package com.zigzag.proxy.satic.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qlk
 */
public class OrderServiceProxy implements OrderService {
    private SimpleDateFormat yearFormat =
            new SimpleDateFormat("yyyy");

    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(
                yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分类到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("before proxy");
    }

    private void after() {
        System.out.println("after proxy");
    }

}
