package com.example.kluxury.controller;

import com.example.kluxury.entity.Brand;
import com.example.kluxury.response.RESTPagination;
import com.example.kluxury.response.RESTResponse;
import com.example.kluxury.service.brand.BrandService;
import com.example.kluxury.service.brand.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/brands")
@CrossOrigin("*")
public class BrandController {

    @Autowired
    private BrandService service;

    @RequestMapping(method = RequestMethod.GET, path = "list")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addDatas(service.getAll())
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "add")
    public ResponseEntity<Object> save(@RequestBody Brand brand){
          return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.save(brand))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "detail")
    public ResponseEntity<Object> findById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.getById(id))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.delete(id))
                .buildData(), HttpStatus.OK);
    }
}
