package com.j3n0.mall.service;

import com.j3n0.mall.model.ForeCategory;
import com.j3n0.mall.model.ForeHomeCategory;

import java.util.List;

public interface ForeCategoryService {

    // get

    // list

    ForeCategory getForeCategory(Long cid);

    List<ForeHomeCategory> listHomeCategories();
}
