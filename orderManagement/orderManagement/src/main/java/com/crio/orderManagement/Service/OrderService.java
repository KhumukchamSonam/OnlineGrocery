package com.crio.orderManagement.Service;

import com.crio.orderManagement.Entity.Order;

public interface OrderService {
    public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public Order deleteOrder(Order order);
    public Order viewOrder(Order order);
}
