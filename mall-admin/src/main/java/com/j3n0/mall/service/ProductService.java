package com.j3n0.mall.service;

import com.j3n0.mall.model.Category;
import com.j3n0.mall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listByCid(Long cid);

    Product get(Long id);

    int create(Product product);

    int update(Long id, Product product);

    int delete(Long id);
}
