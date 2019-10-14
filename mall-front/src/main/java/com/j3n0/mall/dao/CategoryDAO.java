package com.j3n0.mall.dao;

import com.j3n0.mall.model.Category;
import com.j3n0.mall.model.ForeHomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Long> {

    @Query("SELECT " +
            "NEW com.j3n0.mall.model.ForeHomeCategory(c.id, c.name) " +
            "FROM " +
            "Category c ")
    List<ForeHomeCategory> listForeHomeCategories();
}
