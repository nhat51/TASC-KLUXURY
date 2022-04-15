package com.example.kluxury.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;

//    @JoinColumn(name = "product_id")
    private int product_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
