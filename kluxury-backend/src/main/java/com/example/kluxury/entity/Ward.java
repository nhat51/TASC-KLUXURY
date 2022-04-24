package com.example.kluxury.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "wards")
public class Ward extends BaseEntity{
    @Id
    private int id;
    private String name;
    @Column(name = "district_id")
    private int district_id;

    @ManyToOne
    @JoinColumn(name = "district_id",insertable = false,updatable = false)
    @JsonIgnore
    private District district;
}
