package com.example.kluxury.service.product;

import com.example.kluxury.entity.Product;
import com.example.kluxury.entity.dto.ProductDto;
import com.example.kluxury.response.MyPage;
import com.example.kluxury.response.ResponseApi;
import com.example.kluxury.utils.ProductFilter;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductsService {
    MyPage findAll(ProductFilter filter);
    ProductDto getById(int id);
    Product save(Product product);
    ProductDto delete(int id);
    ProductDto update(int id, Product product);
}
