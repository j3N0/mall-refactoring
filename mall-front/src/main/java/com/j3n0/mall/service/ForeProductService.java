package com.j3n0.mall.service;

import com.j3n0.mall.model.ForeHomeProduct;
import com.j3n0.mall.model.ForeProduct;
import com.j3n0.mall.model.Product;

import java.util.List;

public interface ForeProductService {

    // get

    // list

    ForeProduct getForeProduct(Long pid);

    List<ForeHomeProduct> listHomeProducts(Long cid);

    List<List<ForeHomeProduct>> listRecommendProducts(Long cid);

    int update(Long id, Product product);
}
