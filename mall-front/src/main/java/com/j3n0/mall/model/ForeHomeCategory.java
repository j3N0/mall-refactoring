package com.j3n0.mall.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class ForeHomeCategory extends Category {

    public ForeHomeCategory(Long id, String name) {
        super(id, name);
    }

    List<ForeHomeProduct> products;
}
