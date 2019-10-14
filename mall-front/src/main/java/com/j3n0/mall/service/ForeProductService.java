package com.j3n0.mall.service;

import com.j3n0.mall.model.ForeHomeProduct;

import java.util.List;

public interface ForeProductService {

    // get

    // list

    List<ForeHomeProduct> listHomeProducts(Long cid);

    List<List<ForeHomeProduct>> listRecommendProducts(Long cid);
}
