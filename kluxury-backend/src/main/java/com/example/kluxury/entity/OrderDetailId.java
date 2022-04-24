package com.example.kluxury.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "product_id")
    int product_id;
    @Column(name = "order_id")
    int order_id;
}
