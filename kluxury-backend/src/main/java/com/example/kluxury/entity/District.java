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
@Entity(name = "districts")
public class District extends BaseEntity{
    @Id
    private int id;
    private String name;
    @Column(name = "province_id")
    private int province_id;

    @OneToMany(mappedBy = "district")
    private Set<Ward> wards;

    @ManyToOne
    @JoinColumn(name = "province_id",insertable = false,updatable = false)
    @JsonIgnore
    private Province province;
}
