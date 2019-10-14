package com.j3n0.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForeHomeProduct {

    private Long pid;

    private String name;

    private String pic;

    private Float price;
}
