package com.example.kluxury.service.category;

import com.example.kluxury.entity.Category;
import com.example.kluxury.entity.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    Category findById(int id);
    Category update(int id, Category category);
    boolean delete(int id);
}
