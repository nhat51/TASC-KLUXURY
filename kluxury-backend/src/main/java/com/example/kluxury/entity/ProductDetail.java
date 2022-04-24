package com.example.kluxury.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product_details")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    private String size;
    private double price;
    private int in_stock;
    private LocalDate created_at;
    private LocalDate updated_at;

    @Column(name = "product_id")
    private int product_id;

    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    @JsonIgnore
    private Product product;
}
