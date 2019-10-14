package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subtitle;

    private String pic;

    private Float price;

    private Float promotionalPrice;

    private Integer sku;

    private Integer salesNum;

    private Integer commentsNum;

    private Date createDate;

    @Column(name = "cid")
    private Long cid;
}
