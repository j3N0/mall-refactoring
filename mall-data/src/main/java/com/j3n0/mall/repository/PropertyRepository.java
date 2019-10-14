package com.j3n0.mall.repository;

import com.j3n0.mall.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByCid(Long cid);
}
