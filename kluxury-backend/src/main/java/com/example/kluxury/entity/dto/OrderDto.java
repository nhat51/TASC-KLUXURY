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
public class OrderDto {
    private int id;
    private String customer_name;
    private String ship_address;
    private String phone_number;
    private String ship_note;
    private int user_id;
    private LocalDate created_at;
    private LocalDate updated_at;
}
