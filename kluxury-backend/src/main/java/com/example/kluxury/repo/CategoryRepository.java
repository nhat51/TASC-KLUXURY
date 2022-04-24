package com.example.kluxury.repo;

import com.example.kluxury.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM categories c where c.is_delete = false ")
    List<Category> getAll();
}
