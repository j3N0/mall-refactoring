package com.j3n0.mall.controller;

import com.j3n0.mall.model.ForeProduct;
import com.j3n0.mall.service.ForeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForeProductController {

    // get product

    @Autowired
    ForeProductService foreProductService;

    @GetMapping("/fore/products/{pid}")
    public ForeProduct getForeProduct(@PathVariable Long pid) {
        return foreProductService.getForeProduct(pid);
    }
}
