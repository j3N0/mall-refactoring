package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    private Long uid;

    private String address;

    private String postcode;

    private String consigneeName;

    private String phoneNumber;

    private String note;

    // 0 -> 待付款, 1 -> 待发货, 2 -> 已发货, 3 -> 已收货, 4 -> 已完成
    private Integer status;

    // 0 -> 未删除, 1 -> 已删除
    private Integer deleteStatus;

    private Float totalAmount;

    private Date createDate;
}
