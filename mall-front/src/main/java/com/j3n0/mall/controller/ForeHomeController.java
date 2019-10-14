package com.j3n0.mall.controller;

import com.j3n0.mall.model.ForeHomeCategory;
import com.j3n0.mall.model.ForeHomeProduct;
import com.j3n0.mall.service.ForeCategoryService;
import com.j3n0.mall.service.ForeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeHomeController {

    // list categories

    // list recommend products
    @Autowired
    ForeCategoryService foreCategoryService;

    @Autowired
    ForeProductService foreProductService;

    @GetMapping("/fore/home")
    public List<ForeHomeCategory> home() {
        return foreCategoryService.listHomeCategories();
    }

    @GetMapping("/fore/recommendProducts/{cid}")
    public List<List<ForeHomeProduct>> listRecommendProducts(@PathVariable Long cid) {
        return foreProductService.listRecommendProducts(cid);
    }
}
