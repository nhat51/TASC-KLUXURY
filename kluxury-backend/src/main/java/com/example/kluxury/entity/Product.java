package com.example.kluxury.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @Column(columnDefinition = "TEXT")
    private String description;
    private int status;
    @Column(columnDefinition = "TEXT")
    private String images;
    private double rating;
    private String html_description;


    @Column(name = "category_id")
    private int category_id;
    @Column(name = "brand_id")
    private int brand_id;

    @ManyToOne
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id",insertable = false,updatable = false)
    @JsonIgnore
    private Brand brand;

    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    Set<ProductDetail> productDetails;
}
