package com.example.kluxury.controller;

import com.example.kluxury.entity.OrderDetail;
import com.example.kluxury.entity.dto.OrderDetailDto;
import com.example.kluxury.entity.dto.OrderDto;
import com.example.kluxury.response.RESTResponse;
import com.example.kluxury.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    OrderService service;

    @RequestMapping(method = RequestMethod.GET,path = "cart")
    public ResponseEntity<Object> getCart(@RequestHeader(name = "user_id") int userId){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.getCart(userId))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "add_to_cart")
    public ResponseEntity<Object> addToCart(@RequestHeader(name = "user_id") int userId, @RequestBody OrderDetailDto orderDetailDto){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.addToCart(userId,orderDetailDto))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "update_cart")
    public ResponseEntity<Object> updateCart(@RequestHeader(name = "user_id") int userId, @RequestBody Set<OrderDetail> list){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.updateCart(userId,list))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "remove")
    public ResponseEntity<Object> remove(@RequestHeader(name = "user_id") int userId, @RequestParam(name = "product_id") int productId){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.removeItem(userId,productId))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "proceed_order")
    public ResponseEntity<Object> proceedOrder(@RequestHeader(name = "user_id") int userId, @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.proceedOrder(userId,orderDto))
                .buildData(), HttpStatus.OK);
    }
}
