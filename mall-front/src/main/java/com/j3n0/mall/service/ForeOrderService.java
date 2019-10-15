package com.j3n0.mall.service;

import com.j3n0.mall.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ForeOrderService {

    /**
     * 用户直接购买商品生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder(ForeCartItemParam param, Long uid);


    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder(Long uid);

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    GenerateOrderResult generateOrder(GenerateOrderParam param, Long uid);

    /**
     * 支付成功后的回调
     */
    @Transactional
    int paySuccess(Long orderId);

    /**
     * 查询用户订单列表
     */
    List<ForeOrder> listForeOrder(Long uid);
}
