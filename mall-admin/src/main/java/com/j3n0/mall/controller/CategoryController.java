package com.j3n0.mall.controller;

import com.j3n0.mall.model.Category;
import com.j3n0.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    // list

    // get

    // create

    // update

    // delete

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list() {
        return categoryService.list();
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @PostMapping("/categories")
    public String create(@RequestBody Category category) {
        int count = categoryService.create(category);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @PutMapping("/categories/{id}")
    public String update(@PathVariable Long id, @RequestBody Category category) {
        int count = categoryService.update(id, category);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable long id) {
        int count = categoryService.delete(id);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
