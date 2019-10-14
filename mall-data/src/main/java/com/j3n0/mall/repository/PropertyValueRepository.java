package com.j3n0.mall.repository;

import com.j3n0.mall.model.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueRepository extends JpaRepository<PropertyValue, Long> {

    List<PropertyValue> findByPid(Long pid);

    List<PropertyValue> findByPtid(Long ptid);
}
