package com.aidivaa.controller;

import java.util.*;

import com.aidivaa.entity.Product;
import com.aidivaa.service.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    // RESTful API methods for Retrieval operations

    // RESTful API method for Create operation

    // RESTful API method for Update operation

    // RESTful API method for Delete operation
    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }

    // API method to fetch the specific Payment mode
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getLazyProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(Map.of("data",service.getLazy(id).getName(),"message","suc_fetch","status","success"),HttpStatus.OK);
    }

    // API method to fetch the specific Payment mode
    @GetMapping("/productOrders/{id}")
    public ResponseEntity<?> getEagerProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(Map.of("data",service.getLazy(id).getOrderDetail(),"message","suc_fetch","status","success"),HttpStatus.OK);
    }
}
