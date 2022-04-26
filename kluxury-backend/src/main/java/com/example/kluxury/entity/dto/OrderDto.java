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
    private String customer_name;
    private int province_id;
    private int district_id;
    private int ward_id;
    private String ship_address;
    private String phone_number;
    private String ship_note;
    private int user_id;
}
