package com.example.kluxury.controller;

import com.example.kluxury.entity.Order;
import com.example.kluxury.entity.OrderDetail;
import com.example.kluxury.entity.dto.OrderDetailDto;
import com.example.kluxury.entity.dto.OrderDto;
import com.example.kluxury.response.MyPage;
import com.example.kluxury.response.RESTPagination;
import com.example.kluxury.response.RESTResponse;
import com.example.kluxury.service.order.OrderService;
import com.example.kluxury.utils.OrderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService service;

    @RequestMapping(method = RequestMethod.GET,path = "list")
    public ResponseEntity<Object> listProduct(@RequestParam(name = "page",defaultValue = "1") int page,
                                              @RequestParam(name = "pageSize",defaultValue = "5") int pageSize,
                                              @RequestParam(name = "provinceId",defaultValue = "-1") int provinceId,
                                              @RequestParam(name = "districtId",defaultValue = "-1") int districtId,
                                              @RequestParam(name = "wardId", defaultValue = "-1") int wardId,
                                              @RequestParam(name = "userId", defaultValue = "-1") int userId
                                              ){
        OrderFilter filter = OrderFilter.OrderFilterBuilder
                .anOrderFilter()
                .withPage(page)
                .withPageSize(pageSize)
                .withProvince_id(provinceId)
                .withDistrict_id(districtId)
                .withWard_id(wardId)
                .withUser_id(userId)
                .build();
        MyPage paging = service.getAll(filter);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setPagination(new RESTPagination(paging.getPage() + 1, paging.getPageSize(), paging.getTotalPage()))
                .addDatas((List<Order>) paging.getContent())
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "cart")
    public ResponseEntity<Object> getCart(@RequestHeader(name = "user_id") int userId){
        return new ResponseEntity<>(service.getCart(userId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "add_to_cart")
    public ResponseEntity<Object> addToCart(@RequestHeader(name = "user_id") int userId, @RequestBody OrderDetailDto orderDetailDto){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.addToCart(userId,orderDetailDto))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "update_cart")
    public ResponseEntity<Object> updateCart(@RequestHeader(name = "user_id") int userId, @RequestBody int productId){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.updateCart(userId,productId))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "remove")
    public ResponseEntity<Object> remove(@RequestHeader(name = "user_id") int userId, @RequestParam(name = "product_id") int productId){
        return new ResponseEntity<>(service.removeItem(userId,productId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "proceed_order")
    public ResponseEntity<Object> proceedOrder(@RequestHeader(name = "user_id") int userId, @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.proceedOrder(userId,orderDto))
                .buildData(), HttpStatus.OK);
    }
}
