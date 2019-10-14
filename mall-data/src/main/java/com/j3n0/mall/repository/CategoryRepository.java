package com.j3n0.mall.repository;

import com.j3n0.mall.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
