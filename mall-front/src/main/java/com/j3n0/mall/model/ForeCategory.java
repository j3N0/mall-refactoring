package com.j3n0.mall.model;

import lombok.Data;

import java.util.List;

@Data
public class ForeCategory {

    private Category category;

    private List<Product> products;
}
