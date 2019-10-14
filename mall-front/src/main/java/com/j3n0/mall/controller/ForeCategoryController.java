package com.j3n0.mall.controller;

import com.j3n0.mall.model.ForeCategory;
import com.j3n0.mall.service.ForeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForeCategoryController {

    // get category

    @Autowired
    ForeCategoryService foreCategoryService;

    @GetMapping("/fore/categories/{cid}")
    public ForeCategory getForeCategory(@PathVariable Long cid) {
        return foreCategoryService.getForeCategory(cid);
    }
}
