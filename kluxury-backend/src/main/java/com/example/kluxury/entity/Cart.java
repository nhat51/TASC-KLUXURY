package com.example.kluxury.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "carts")
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total_price;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;

    @OneToOne(mappedBy = "cart")
    @JoinColumn(name = "user_id")
    private User user;
}
