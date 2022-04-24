package com.example.kluxury.repo;

import com.example.kluxury.entity.Brand;
import com.example.kluxury.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query("SELECT b FROM brands b where b.is_delete = false ")
    List<Brand> getAll();
}
