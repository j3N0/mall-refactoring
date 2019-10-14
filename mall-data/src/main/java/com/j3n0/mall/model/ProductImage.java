package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid")
    private Long pid;

    // 0 -> 相册, 1 -> 详情
    private Integer type;
}
