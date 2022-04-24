package com.example.kluxury.repo;

import com.example.kluxury.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from orders o where o.is_shopping_cart = true")
    Order getCart();
}
