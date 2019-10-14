package com.j3n0.mall.controller;

import com.j3n0.mall.model.CartItem;
import com.j3n0.mall.model.ForeCartItemParam;
import com.j3n0.mall.service.ForeCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ForeCartItemController {

    @Autowired
    ForeCartItemService foreCartItemService;

    @PostMapping("/fore/users/{uid}/cartItems")
    public String addCartItem(@RequestBody ForeCartItemParam param, @PathVariable Long uid) {
        int count = foreCartItemService.add(param, uid);
        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @GetMapping("/fore/users/{uid}/cartItems")
    public List<CartItem> listCartItem(@PathVariable Long uid) {
        return foreCartItemService.list(uid);
    }

    @DeleteMapping("/fore/users/{uid}/cartItems")
    public String deleteCartItem(@RequestBody ForeCartItemParam param, @PathVariable Long uid) {
        int count = foreCartItemService.delete(param, uid);
        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @PutMapping("/fore/users/{uid}/cartItems")
    public String updateCartItem(@RequestBody ForeCartItemParam param, @PathVariable Long uid) {
        int count = foreCartItemService.update(param, uid);
        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
