package com.j3n0.mall.service;

import com.j3n0.mall.model.CartItem;
import com.j3n0.mall.model.ForeCartItemParam;

import java.util.List;

public interface ForeCartItemService {

    int add(ForeCartItemParam param, Long uid);

    List<CartItem> list(Long uid);

    int delete(ForeCartItemParam param, Long uid);

    int update(ForeCartItemParam param, Long uid);

    CartItem generateCartItem(ForeCartItemParam param, Long uid);
}
