package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oid")
    private Long oid;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    private Integer number;

    // 0 -> 未评价, 1 -> 已评价
    private Integer commentStatus;
}
