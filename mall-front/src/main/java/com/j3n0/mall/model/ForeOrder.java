package com.j3n0.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ForeOrder {

    private Long orderId;

    private Long uid;

    // 0 -> 待付款, 1 -> 待发货, 2 -> 已发货, 3 -> 已收货, 4 -> 已完成
    private Integer status;

    // 0 -> 未删除, 1 -> 已删除
    private Integer deleteStatus;

    private Float totalAmount;

    private Date createDate;

    private List<OrderItem> orderItems;

    public ForeOrder(Long orderId, Long uid, Integer status, Integer deleteStatus, Float totalAmount,
                     Date createDate) {
        this.orderId = orderId;
        this.uid = uid;
        this.status = status;
        this.deleteStatus = deleteStatus;
        this.totalAmount = totalAmount;
        this.createDate = createDate;
    }
}
