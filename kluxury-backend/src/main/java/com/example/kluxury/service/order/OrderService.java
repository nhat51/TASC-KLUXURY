package com.example.kluxury.service.order;

import com.example.kluxury.entity.Order;
import com.example.kluxury.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    Order addToCart(int userId, OrderDetail orderDetail);
    Order creatOrder(int userId);
    List<Order> getAll();
    List<Order> getByUserId();
}
