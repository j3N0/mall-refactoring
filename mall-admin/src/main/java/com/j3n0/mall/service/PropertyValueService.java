package com.j3n0.mall.service;


import com.j3n0.mall.model.PropertyValue;

import java.util.List;

public interface PropertyValueService {

    List<PropertyValue> listByPid(Long pid);

    int update(Long id, PropertyValue propertyValue);
}
