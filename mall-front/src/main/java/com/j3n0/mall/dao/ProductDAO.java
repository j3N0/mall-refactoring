package com.j3n0.mall.dao;

import com.j3n0.mall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long> {
}
