package com.j3n0.mall.service.impl;

import com.j3n0.mall.dao.CategoryDAO;
import com.j3n0.mall.dao.ProductDAO;
import com.j3n0.mall.model.*;
import com.j3n0.mall.service.ForeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeCategoryServiceImpl implements ForeCategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @Override
    public ForeCategory getForeCategory(Long cid) {
        ForeCategory foreCategory = new ForeCategory();
        // Todo 异常处理
        Category category = categoryDAO.findById(cid).orElseThrow(RuntimeException::new);
        List<Product> products = productDAO.findByCid(category.getId());

        foreCategory.setCategory(category);
        foreCategory.setProducts(products);
        return foreCategory;
    }

    @Override
    public List<ForeHomeCategory> listHomeCategories() {

        List<ForeHomeCategory> homeCategories = categoryDAO.listForeHomeCategories();

        for (ForeHomeCategory homeCategory : homeCategories) {
            List<ForeHomeProduct> homeProducts = productDAO.listForeHomeProducts(homeCategory.getId());
            homeCategory.setProducts(homeProducts);
        }
        return homeCategories;
    }
}
