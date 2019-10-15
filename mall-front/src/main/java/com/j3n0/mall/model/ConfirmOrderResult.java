package com.j3n0.mall.model;

import lombok.Data;

import java.util.List;

@Data
public class ConfirmOrderResult {

    List<CartItem> cartItemList;

    Float totalAmount;
}
