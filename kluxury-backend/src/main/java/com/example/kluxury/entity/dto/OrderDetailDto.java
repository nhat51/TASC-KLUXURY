package com.example.kluxury.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private int id;
    private int product_id;
    private String product_name;
    private double unit_price;
    private int amount;
    private double total_price;
    private int order_id;
    private LocalDate created_at;
    private LocalDate updated_at;
}
