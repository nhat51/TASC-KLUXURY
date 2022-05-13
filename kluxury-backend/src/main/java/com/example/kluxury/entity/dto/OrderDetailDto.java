package com.example.kluxury.entity.dto;

import lombok.*;

import java.time.LocalDate;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private int product_id;
    private int amount;
    private int is_increase;
}
