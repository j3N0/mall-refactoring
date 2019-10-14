package com.j3n0.mall.dao;

import com.j3n0.mall.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Long> {
}
