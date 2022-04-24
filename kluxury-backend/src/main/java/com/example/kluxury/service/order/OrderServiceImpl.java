package com.example.kluxury.service.order;

import com.example.kluxury.entity.Order;
import com.example.kluxury.entity.OrderDetail;
import com.example.kluxury.repo.OrderDetailRepository;
import com.example.kluxury.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public Order addToCart(int userId, OrderDetail orderDetail) {
        Order exist = orderRepository.getCart();
        if (exist != null){
            Set<OrderDetail> listOrderDetail = exist.getOrderDetails();
            for (OrderDetail od : listOrderDetail) {
                if (od.getProduct().getId() == orderDetail.getProduct().getId()){
                    od.setAmount(od.getAmount() + 1);
                    exist.setTotalMoney();
                    return exist;
                }
                od.setOrder(exist);
                listOrderDetail.add(orderDetail);
                exist.setOrderDetails(listOrderDetail);
                exist.setTotalMoney();
                return exist;
            }
        }
        Order newOrder = new Order();
        newOrder.set_shopping_cart(true);
        newOrder.setUser_id(userId);
        Set<OrderDetail> newListOrderDetail = new HashSet<>();
        orderDetail.setOrder(newOrder);
        newListOrderDetail.add(orderDetail);
        newOrder.setOrderDetails(newListOrderDetail);
        newOrder.setTotalMoney();
        return orderRepository.save(newOrder);
    }

    @Override
    public Order creatOrder(int userID) {
        Order order = new Order();
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> getByUserId() {
        return null;
    }
}
