package com.example.kluxury.service.category;

import com.example.kluxury.entity.Category;
import com.example.kluxury.entity.Product;
import com.example.kluxury.entity.dto.CategoryDto;
import com.example.kluxury.repo.CategoryRepository;
import com.example.kluxury.utils.ConvertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        List<Category> listAll= categoryRepository.getAll();
        List<Category> listParent= new ArrayList<>();
        for (int i = 0; i < listAll.size(); i++) {
            if (listAll.get(i).getParentCategory() == null){
                listParent.add(listAll.get(i));
            }
        }

        return listParent;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public Category update(int id, Category category) {
        Category updateCategory = categoryRepository.getById(id);
        updateCategory.setName(category.getName());
        updateCategory.setUpdatedAt(LocalDate.now());
        updateCategory.setListSubCategory(category.getListSubCategory());
        return updateCategory;
    }

    @Override
    public boolean delete(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){
            categoryRepository.delete(category.get());
            return true;
        }
        return false;
    }
}
