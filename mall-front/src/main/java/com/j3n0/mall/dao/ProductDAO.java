package com.j3n0.mall.dao;

import com.j3n0.mall.model.ForeHomeProduct;
import com.j3n0.mall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    @Query("SELECT " +
            "NEW com.j3n0.mall.model.ForeHomeProduct(p.id, p.name, p.pic, p.promotionalPrice) " +
            "FROM " +
            "Product p " +
            "WHERE p.cid = :cid")
    List<ForeHomeProduct> listForeHomeProducts(@Param("cid") Long cid);

    List<Product> findByCid(Long cid);
}
