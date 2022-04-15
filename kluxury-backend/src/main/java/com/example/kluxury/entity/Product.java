package com.example.kluxury.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private int status;


//    @JoinColumn(name = "category_id")
    private int category_id;
//    @JoinColumn(name = "brand_id")
    private int brand_id;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private Brand brand;
}
