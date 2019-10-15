package com.j3n0.mall.model;

import lombok.Data;

import java.util.List;

@Data
public class GenerateOrderParam {

    private String address;

    private String postcode;

    private String consigneeName;

    private String phoneNumber;

    private String note;

    private List<ForeCartItemParam> cartItemParams;
}
