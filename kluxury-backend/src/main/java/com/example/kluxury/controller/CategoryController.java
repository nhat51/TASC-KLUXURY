package com.example.kluxury.controller;

import com.example.kluxury.entity.Category;
import com.example.kluxury.response.RESTResponse;
import com.example.kluxury.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

        @Autowired
        private CategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.getAll())
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "save")
    public ResponseEntity<Object> getById(@RequestBody Category category){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.save(category))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "detail")
    public ResponseEntity<Object> getById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.findById(id))
                .buildData(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "update")
    public ResponseEntity<Object> update(@RequestParam(name = "id") int id, @RequestBody Category category){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.update(id, category))
                .buildData(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET,path = "delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(service.delete(id))
                .buildData(), HttpStatus.OK);
    }
}
