package com.example.kluxury.service.order;

import com.example.kluxury.entity.Order;
import com.example.kluxury.entity.OrderDetail;
import com.example.kluxury.entity.dto.OrderDetailDto;
import com.example.kluxury.entity.dto.OrderDto;
import com.example.kluxury.response.MyPage;
import com.example.kluxury.utils.OrderFilter;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Order getCart(int userId);
    Order addToCart(int userId, OrderDetailDto orderDetailDto);
    Order updateCart(int userId, Set<OrderDetail> list);
    Order removeItem(int userId, int productId);
    Order proceedOrder(int userId, OrderDto orderDto);
    MyPage getAll(OrderFilter filter);
    List<Order> getByUserId();
}
