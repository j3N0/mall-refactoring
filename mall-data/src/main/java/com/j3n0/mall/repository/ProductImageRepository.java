package com.j3n0.mall.repository;

import com.j3n0.mall.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findByPid(Long pid);
}
