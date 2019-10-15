package com.j3n0.mall.controller;

import com.j3n0.mall.model.*;
import com.j3n0.mall.service.ForeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ForeOrderController {
    @Autowired
    ForeOrderService foreOrderService;

    @PostMapping("/fore/users/{uid}/buyNowConfirmOrder")
    public ConfirmOrderResult buyNowConfirmOrder(@RequestBody ForeCartItemParam param, @PathVariable Long uid) {
        return foreOrderService.generateConfirmOrder(param, uid);
    }

    @PostMapping("/fore/users/{uid}/cartConfirmOrder")
    public ConfirmOrderResult cartConfirmOrder(@PathVariable Long uid) {
        return foreOrderService.generateConfirmOrder(uid);
    }

    @PostMapping("/fore/users/{uid}/generateOrder")
    public GenerateOrderResult generateOrder(@RequestBody GenerateOrderParam param, @PathVariable Long uid) {
        return foreOrderService.generateOrder(param, uid);
    }

    @PostMapping("/fore/orders/{orderId}/paySuccess")
    public String paySuccess(@PathVariable Long orderId) {
        int count = foreOrderService.paySuccess(orderId);
        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @GetMapping("/fore/users/{uid}/orders")
    public List<ForeOrder> listForeOrder(@PathVariable Long uid) {
        return foreOrderService.listForeOrder(uid);
    }
}
