package com.example.kluxury.utils;

import com.example.kluxury.entity.Brand;
import com.example.kluxury.entity.Category;
import com.example.kluxury.entity.Product;
import com.example.kluxury.entity.dto.BrandDto;
import com.example.kluxury.entity.dto.CategoryDto;
import com.example.kluxury.entity.dto.ProductDto;

public class ConvertDto {

    public static ProductDto convertProductEntity(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCreated_at(product.getCreated_at());
        productDto.setUpdated_at(product.getUpdated_at());
        productDto.setImages(product.getImages());
        productDto.setStatus(product.getStatus());
        productDto.setBrandDto(convertBrandEntity(product.getBrand()));
        productDto.setCategoryDto(convertCategoryEntity(product.getCategory()));
        System.out.println(product.getBrand().getName());
        return productDto;
    }

    public static BrandDto convertBrandEntity(Brand brand){
        BrandDto brandDto = new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setName(brand.getName());
        brandDto.setImage(brand.getBrandImage());
        return brandDto;
    }

    public static CategoryDto convertCategoryEntity(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }


}
