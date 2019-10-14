package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    private Integer number;
}
