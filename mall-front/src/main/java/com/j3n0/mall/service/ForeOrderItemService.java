package com.j3n0.mall.service;

import com.j3n0.mall.model.CartItem;
import com.j3n0.mall.model.OrderItem;

import java.util.List;

public interface ForeOrderItemService {

    List<OrderItem> generateOrderItems(List<CartItem> cartItems);
}
