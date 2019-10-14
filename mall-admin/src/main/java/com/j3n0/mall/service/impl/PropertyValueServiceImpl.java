package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.PropertyValue;
import com.j3n0.mall.repository.PropertyValueRepository;
import com.j3n0.mall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    PropertyValueRepository propertyValueRepository;

    @Override
    public List<PropertyValue> listByPid(Long pid) {
        return propertyValueRepository.findByPid(pid);
    }

    @Override
    public int update(Long id, PropertyValue propertyValue) {
        int count;
        propertyValue.setId(id);
        propertyValueRepository.save(propertyValue);
        count = 1;
        return count;
    }
}
