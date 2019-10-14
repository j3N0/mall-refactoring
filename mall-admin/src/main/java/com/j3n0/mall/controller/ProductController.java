package com.j3n0.mall.controller;

import com.j3n0.mall.model.Category;
import com.j3n0.mall.model.Product;
import com.j3n0.mall.service.CategoryService;
import com.j3n0.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    // list by category

    // get

    // create

    // update

    // delete

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories/{cid}/products")
    public List<Product> listByCategory(@PathVariable Long cid) {
        return productService.listByCid(cid);
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable Long id) {
        return productService.get(id);
    }

    @PostMapping("/products")
    public String create(@RequestBody Product product) {
        int count = productService.create(product);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @PutMapping("/products/{id}")
    public String update(@PathVariable Long id, @RequestBody Product product) {
        int count = productService.update(id, product);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable long id) {
        int count = productService.delete(id);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
