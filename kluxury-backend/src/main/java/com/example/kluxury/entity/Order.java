package com.example.kluxury.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "orders")
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customer_name;
    private String ship_address;
    private String ship_city;
    private String ship_district;
    private String ship_ward;
    private String ship_phone;
    private double totalPrice;
    @Column(columnDefinition = "TEXT")
    private String ship_note;
    @Column(name = "user_id",insertable = false,updatable = false)
    private int user_id;

    private boolean is_shopping_cart;
    private boolean is_checkout;
    private int status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    @JsonIgnore
    public int getTotal(){
        Set<OrderDetail> list = this.getOrderDetails();
        int total = 0;
        for(OrderDetail detail : list){
            total +=detail.getUnit_price() * detail.getAmount();
        }
        return total;
    }
    @JsonIgnore
    public void setTotalMoney(){
        this.totalPrice = getTotal();
    }
}
