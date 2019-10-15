package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.CartItem;
import com.j3n0.mall.model.OrderItem;
import com.j3n0.mall.service.ForeOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForeOrderItemServiceImpl implements ForeOrderItemService {

    @Override
    public List<OrderItem> generateOrderItems(List<CartItem> cartItems) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setNumber(cartItem.getNumber());
            // 0 -> 未评价, 1 -> 已评价
            orderItem.setCommentStatus(0);
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
