package com.example.kluxury.utils;

import com.example.kluxury.entity.Product;
import com.example.kluxury.entity.dto.ProductDto;

public class ConvertEntity {

    public static Product convertProductDto(ProductDto productDto){
        Product converted = new Product();
        converted.setName(productDto.getName());
        converted.setPrice(productDto.getPrice());
        converted.setImages(productDto.getImages());
        converted.setDescription(productDto.getDescription());
        converted.setCreated_at(productDto.getCreated_at());
        converted.setUpdated_at(productDto.getUpdated_at());
        converted.setStatus(productDto.getStatus());
        return converted;
    }
}
