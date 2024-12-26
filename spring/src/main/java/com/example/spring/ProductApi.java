package com.example.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {
    private Long id = 0L;
    List<Product> products = new ArrayList<Product>();
//    String[] productList = {"다이제", "꼬깔콘", "브이콘"};

    // 생성
    // http://localhost:8080/product/create
    @PostMapping
    public Product createProduct() {
//        if (id < productList.length) {
//            Product product = new Product(id, productList[id.intValue()], 2500);
//            id++;
//            return product;
//
//        }
//        return null;

        Product product = new Product(++id, "고구마", 2500);
        products.add(product);
        return product;
    }// createProduct() end
}// class end
