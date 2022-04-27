package com.example.kluxury.controller;

import com.example.kluxury.entity.Product;
import com.example.kluxury.entity.dto.ProductDto;
import com.example.kluxury.repo.ProductRepository;
import com.example.kluxury.response.MyPage;
import com.example.kluxury.response.RESTPagination;
import com.example.kluxury.response.RESTResponse;
import com.example.kluxury.service.product.ProductsService;
import com.example.kluxury.utils.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductsService service;

    @RequestMapping(method = RequestMethod.GET,path = "list")
    public ResponseEntity<Object> listProduct(@RequestParam(name = "page",defaultValue = "1") int page,
                                              @RequestParam(name = "pageSize",defaultValue = "5") int pageSize,
                                              @RequestParam(name = "minPrice",defaultValue = "-1") int minPrice,
                                              @RequestParam(name = "maxPrice",defaultValue = "-1") int maxPrice,
                                              @RequestParam(name = "categoryId", defaultValue = "-1") int categoryId,
                                              @RequestParam(name = "brandID", defaultValue = "-1") int brandId,
                                              @RequestParam(name = "name", required = false) String name){
        ProductFilter filter = ProductFilter.ProductFilterBuilder.aProductFilter()
                .withBrand_id(brandId)
                .withCategory_id(categoryId)
                .withMaxPrice(maxPrice)
                .withMinPrice(minPrice)
                .withPageSize(pageSize)
                .withPage(page)
                .withNameProduct(name)
                .build();
        MyPage paging = service.findAll(filter);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setPagination(new RESTPagination(paging.getPage() + 1, paging.getPageSize(), paging.getTotalPage()))
                .addDatas((List<ProductDto>) paging.getContent())
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "save")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.save(product))
                .buildData(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "detail")
    public ResponseEntity<Object> getProduct(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.getById(id))
                .buildData(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "update")
    public ResponseEntity<Object> updateProduct(@RequestParam(name = "id") int id,@RequestBody Product product){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.update(id,product))
                .buildData(),HttpStatus.OK);
    }
}
