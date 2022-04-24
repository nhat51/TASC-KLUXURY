package com.example.kluxury.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "provinces")
public class Province extends BaseEntity{
    @Id
    private int id;
    private String name;
    private String code;

    @OneToMany(mappedBy = "province")
    private Set<District> districtSetl;
}
