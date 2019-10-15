package com.j3n0.mall.service.impl;

import com.j3n0.mall.dao.OrderDAO;
import com.j3n0.mall.model.*;
import com.j3n0.mall.repository.OrderItemRepository;
import com.j3n0.mall.service.ForeCartItemService;
import com.j3n0.mall.service.ForeOrderItemService;
import com.j3n0.mall.service.ForeOrderService;
import com.j3n0.mall.service.ForeProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForeOrderServiceImpl implements ForeOrderService {

    @Autowired
    ForeCartItemService foreCartItemService;

    @Autowired
    ForeOrderItemService foreOrderItemService;

    @Autowired
    ForeProductService foreProductService;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public ConfirmOrderResult generateConfirmOrder(ForeCartItemParam param, Long uid) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        // 构建单独购买的购物车列表
        List<CartItem> cartItems =  Collections.singletonList(foreCartItemService.generateCartItem(param, uid));
        // 计算总金额
        Float totalAmount = this.calcTotalAmount(cartItems);

        result.setCartItemList(cartItems);
        result.setTotalAmount(totalAmount);
        return result;
    }

    @Override
    public ConfirmOrderResult generateConfirmOrder(Long uid) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        // 获取的购物车列表
        List<CartItem> cartItems = foreCartItemService.list(uid);
        // 计算总金额
        Float totalAmount = this.calcTotalAmount(cartItems);

        result.setCartItemList(cartItems);
        result.setTotalAmount(totalAmount);
        return result;
    }

    @Override
    public GenerateOrderResult generateOrder(GenerateOrderParam param, Long uid) {
        GenerateOrderResult result = new GenerateOrderResult();
        // 获取购物车列表
        List<CartItem> cartItems = param.getCartItemParams()
                .stream()
                .map(cartItemParam -> foreCartItemService.generateCartItem(cartItemParam, uid))
                .collect(Collectors.toList());
        // 计算总金额
        Float totalAmount = this.calcTotalAmount(cartItems);
        // 新建Order
        Order order = new Order();
        order.setUid(uid);
        order.setTotalAmount(totalAmount);
        order.setAddress(param.getAddress());
        order.setPostcode(param.getPostcode());
        order.setConsigneeName(param.getConsigneeName());
        order.setPhoneNumber(param.getPhoneNumber());
        order.setNote(param.getNote());
        // 0 -> 待付款, 1 -> 待发货, 2 -> 已发货, 3 -> 已收货, 4 -> 已完成
        order.setStatus(0);
        // 0 -> 未删除, 1 -> 删除
        order.setDeleteStatus(0);
        order.setCreateDate(new Date());
        // order 保存到数据库
        Order OrderSaved = orderDAO.save(order);
        // cartItem 转换成 OrderItem
        List<OrderItem> orderItems = foreOrderItemService.generateOrderItems(cartItems);
        // orderItems 保存到数据库
        orderItems.forEach(orderItem -> orderItem.setOid(order.getId()));
        orderItemRepository.saveAll(orderItems);

        result.setOrderId(order.getId());
        result.setTotalAmount(totalAmount);
        return result;
    }

    @Override
    public int paySuccess(Long orderId) {
        int count;
        // Todo 异常处理
        Order order = orderDAO.findById(orderId).orElseThrow(RuntimeException::new);
        // 0 -> 待付款, 1 -> 待发货, 2 -> 已发货, 3 -> 已收货, 4 -> 已完成
        order.setStatus(1);
        orderDAO.save(order);
        // 更新产品库存, 销售量 Todo 并发问题
        List<OrderItem> orderItems = orderItemRepository.findByOid(orderId);
        for (OrderItem orderItem : orderItems) {
            Product product = orderItem.getProduct();
            Long id = product.getId();
            int salesNum = product.getSalesNum();
            int sku = product.getSku();
            product.setSalesNum(salesNum + orderItem.getNumber());
            product.setSku(sku - orderItem.getNumber());
            foreProductService.update(id, product);
        }
        count = 1;
        return count;
    }

    @Override
    public List<ForeOrder> listForeOrder(Long uid) {
        // 查询未删除的订单
        List<ForeOrder> foreOrders = orderDAO.listForeOrder(uid)
                .stream()
                .filter(foreOrder -> foreOrder.getDeleteStatus() != 1)
                .collect(Collectors.toList());
        // 设置orderItems 属性
        for (ForeOrder foreOrder : foreOrders) {
            List<OrderItem> orderItems = orderItemRepository.findByOid(foreOrder.getOrderId());
            foreOrder.setOrderItems(orderItems);
        }
        return foreOrders;
    }

    private Float calcTotalAmount(List<CartItem> cartItems) {
        return cartItems
                .stream()
                .map(cartItem -> cartItem.getProduct().getPromotionalPrice() * cartItem.getNumber())
                .reduce(0F, Float::sum);
    }
}
