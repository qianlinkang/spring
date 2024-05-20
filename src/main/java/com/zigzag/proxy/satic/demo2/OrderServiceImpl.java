package com.zigzag.proxy.satic.demo2;

/**
 * @author qlk
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用OrderDao创建订单");
        return orderDao.insert(order);
    }
}
