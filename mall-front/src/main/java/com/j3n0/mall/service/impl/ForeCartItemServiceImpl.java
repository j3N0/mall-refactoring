package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.CartItem;
import com.j3n0.mall.model.ForeCartItemParam;
import com.j3n0.mall.model.Product;
import com.j3n0.mall.repository.CartItemRepository;
import com.j3n0.mall.repository.ProductRepository;
import com.j3n0.mall.service.ForeCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeCartItemServiceImpl implements ForeCartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public int add(ForeCartItemParam param, Long uid) {

        int count;
        CartItem cartItem = this.get(param, uid);

        if (cartItem != null) {
            return this.update(param, uid);
        }

        CartItem cartItemGenerated = this.generateCartItem(param, uid);
        cartItemRepository.save(cartItemGenerated);
        count = 1;
        return count;
    }

    @Override
    public List<CartItem> list(Long uid) {
        return cartItemRepository.findByUid(uid);
    }

    @Override
    public int delete(ForeCartItemParam param, Long uid) {
        int count;
        CartItem cartItem = this.get(param, uid);
        cartItemRepository.delete(cartItem);
        count = 1;
        return count;
    }

    @Override
    public int update(ForeCartItemParam param, Long uid) {
        int count;
        CartItem cartItem = this.get(param, uid);
        cartItem.setNumber(param.getNumber());
        cartItemRepository.save(cartItem);
        count = 1;
        return count;
    }

    @Override
    public CartItem generateCartItem(ForeCartItemParam param, Long uid) {
        CartItem cartItem = new CartItem();
        // Todo 异常处理
        Product product = productRepository.findById(param.getPid()).orElseThrow(RuntimeException::new);

        cartItem.setProduct(product);
        cartItem.setNumber(param.getNumber());
        cartItem.setUid(uid);
        return cartItem;
    }

    private CartItem get(ForeCartItemParam param, Long uid) {
        // Todo 异常处理
        Product product = productRepository.findById(param.getPid()).orElseThrow(RuntimeException::new);
        return cartItemRepository.findByProductAndUid(product, uid);
    }
}
