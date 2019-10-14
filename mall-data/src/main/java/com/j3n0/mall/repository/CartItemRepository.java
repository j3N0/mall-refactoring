package com.j3n0.mall.repository;

import com.j3n0.mall.model.CartItem;
import com.j3n0.mall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUid(Long uid);

    CartItem findByProductAndUid(Product product, Long uid);
}
