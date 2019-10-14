package com.j3n0.mall.service;

import com.j3n0.mall.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> list();

    Category get(Long id);

    int create(Category category);

    int update(Long id, Category category);

    int delete(Long id);
}
