package com.j3n0.mall.repository;

import com.j3n0.mall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCid(Long cid);
}
