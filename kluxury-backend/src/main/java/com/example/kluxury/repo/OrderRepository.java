package com.example.kluxury.repo;

import com.example.kluxury.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from orders o where o.user_id= :id and o.is_shopping_cart = true")
    Order getCart(@Param("id") int id);
}
