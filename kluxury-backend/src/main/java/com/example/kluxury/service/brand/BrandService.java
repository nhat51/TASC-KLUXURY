package com.example.kluxury.service.brand;

import com.example.kluxury.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand save(Brand brand);
    Brand getById(int id);
    Brand update(int id, Brand brand);
    boolean delete(int id);
}
