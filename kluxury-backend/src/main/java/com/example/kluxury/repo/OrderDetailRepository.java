package com.example.kluxury.repo;

import com.example.kluxury.entity.OrderDetail;
import com.example.kluxury.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
