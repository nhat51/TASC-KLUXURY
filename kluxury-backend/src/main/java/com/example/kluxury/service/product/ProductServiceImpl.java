package com.example.kluxury.service.product;

import com.example.kluxury.entity.Category;
import com.example.kluxury.entity.Product;
import com.example.kluxury.entity.dto.ProductDto;
import com.example.kluxury.repo.CategoryRepository;
import com.example.kluxury.repo.ProductRepository;
import com.example.kluxury.response.MyPage;
import com.example.kluxury.response.ResponseApi;
import com.example.kluxury.specification.ProductSpecification;
import com.example.kluxury.specification.SearchCriteria;
import com.example.kluxury.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductsService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Product> findAll(ProductFilter filter) {
        Specification<Product> spec = Specification.where(null);
        PageRequest pageRequest = PageRequest.of(filter.getPage() - 1, filter.getPageSize());
        spec = spec.and(new ProductSpecification(new SearchCriteria(ProductFilter.STATUS, SQLConstant.EQUAL, false)));
        if (filter.getNameProduct() != null && filter.getNameProduct().length() > 0) {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ProductFilter.NAME, SQLConstant.LIKE, filter.getNameProduct())));
        }
        if (filter.getCategory_id() > 0) {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ProductFilter.CATEGORY_ID, SQLConstant.EQUAL, filter.getCategory_id())));
            Optional<Category> parentCategory = categoryRepository.findById(filter.getCategory_id());
            if (parentCategory.isPresent()) {
                if (parentCategory.get().getListSubCategory().size() > 0) {
                    for (Category c : parentCategory.get().getListSubCategory()) {
                        spec = spec.or(new ProductSpecification(new SearchCriteria(ProductFilter.CATEGORY_ID, SQLConstant.EQUAL,c.getId())));                        System.out.println(c.getId());
                    }
                }
            }
        }
        if (filter.getBrand_id() > 0) {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ProductFilter.BRAND_ID, SQLConstant.EQUAL, filter.getBrand_id())));
        }
        if (filter.getMaxPrice() > 0) {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ProductFilter.PRICE, SQLConstant.GREATER_THAN_OR_EQUAL_TO, filter.getMaxPrice())));
        }
        if (filter.getMinPrice() > 0) {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ProductFilter.PRICE, SQLConstant.LESS_THAN_OR_EQUAL_TO, filter.getMinPrice())));
        }
        Page page = productRepository.findAll(spec, pageRequest);
        /*List<Product> products = page.getContent();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product p: products) {
            dtoList.add(ConvertDto.convertProductEntity(p));
        }
        MyPage mypage = new MyPage();
        mypage.setContent(dtoList);
        mypage.setPageSize(page.getSize());
        mypage.setTotalPage(page.getTotalPages());
        mypage.setPage(page.getNumber() + 1);*/
        return productRepository.findAll(spec, pageRequest);
    }

    @Override
    public Page<Product> getProductByCategory(int parentId) {

        return null;
    }

    @Override
    public ProductDto getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductDto dto = ConvertDto.convertProductEntity(product.get());
            return dto;
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        product.setCreatedAt(LocalDate.now());
        product.setUpdatedAt(LocalDate.now());
        productRepository.save(product);
        return product;
    }

    @Override
    public ProductDto delete(int id) {
        Product deleteProduct = productRepository.getById(id);
        deleteProduct.setStatus(-1);
        productRepository.save(deleteProduct);
        return ConvertDto.convertProductEntity(deleteProduct);
    }

    @Override
    public ProductDto update(int id, Product product) {
        Optional<Product> findProduct = productRepository.findById(id);
        if (findProduct.isPresent()) {
            findProduct.get().setName(product.getName());
            findProduct.get().setPrice(product.getPrice());
            findProduct.get().setBrand_id(product.getBrand_id());
            findProduct.get().setCategory_id(product.getCategory_id());
            findProduct.get().setDescription(product.getDescription());
            findProduct.get().setImages(product.getImages());
            findProduct.get().setUpdatedAt(LocalDate.now());
            productRepository.save(findProduct.get());

            return ConvertDto.convertProductEntity(findProduct.get());
        }

        return null;
    }
}
