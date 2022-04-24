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
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String images;
    private int status;
    private BrandDto brandDto;
    private CategoryDto categoryDto;
}
