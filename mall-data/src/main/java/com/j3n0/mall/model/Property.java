package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cid")
    private Long cid;

    private String name;
}
