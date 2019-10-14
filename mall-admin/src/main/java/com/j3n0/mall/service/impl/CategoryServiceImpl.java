package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.Category;
import com.j3n0.mall.repository.CategoryRepository;
import com.j3n0.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(Long id) {
        // Todo 加入异常处理
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public int create(Category category) {
        int count;
        categoryRepository.save(category);
        count = 1;
        return count;
    }

    @Override
    public int update(Long id, Category category) {
        int count;
        category.setId(id);
        categoryRepository.save(category);
        count = 1;
        return count;
    }

    @Override
    public int delete(Long id) {
        int count;
        categoryRepository.deleteById(id);
        count = 1;
        return count;
    }
}
