package com.j3n0.mall.model;

import lombok.Data;

import java.util.List;

@Data
public class ForeProduct {

    private Product product;

    private List<Comment> comments;

    private List<ProductImage> productImages;

    private List<PropertyValue> propertyValues;
}
