package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.Product;
import com.j3n0.mall.repository.ProductRepository;
import com.j3n0.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> listByCid(Long cid) {
        return productRepository.findByCid(cid);
    }

    @Override
    public Product get(Long id) {
        // Todo 异常处理
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public int create(Product product) {
        int count;
        productRepository.save(product);
        count = 1;
        return count;
    }

    @Override
    public int update(Long id, Product product) {
        int count;
        product.setId(id);
        productRepository.save(product);
        count = 1;
        return count;
    }

    @Override
    public int delete(Long id) {
        int count;
        productRepository.deleteById(id);
        count = 1;
        return count;
    }
}
