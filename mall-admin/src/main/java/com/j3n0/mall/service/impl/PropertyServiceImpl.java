package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.Property;
import com.j3n0.mall.model.PropertyValue;
import com.j3n0.mall.repository.ProductRepository;
import com.j3n0.mall.repository.PropertyRepository;
import com.j3n0.mall.repository.PropertyValueRepository;
import com.j3n0.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyValueRepository propertyValueRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Property> listByCid(Long cid) {
        return propertyRepository.findByCid(cid);
    }

    @Override
    public Property get(Long id) {
        // Todo 异常处理
        return propertyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public int create(Property property) {
        int count;
        Property propertySaved = propertyRepository.save(property);
        //创建属性时初始化关联产品的属性值
        List<PropertyValue> propertyValues = createPropertyValues(propertySaved);
        propertyValueRepository.saveAll(propertyValues);
        count = 1;
        return count;
    }

    // 新建关联产品的属性值
    private List<PropertyValue> createPropertyValues(Property property) {
        return productRepository.findByCid(property.getCid())
                .stream()
                .map(product -> PropertyValue.builder().pid(product.getId()).ptid(property.getId()).build())
                .collect(Collectors.toList());
    }

    @Override
    public int update(Long id, Property property) {
        int count;
        property.setId(id);
        propertyRepository.save(property);
        count = 1;
        return count;
    }

    @Override
    public int delete(Long id) {
        int count;
        propertyRepository.deleteById(id);
        // 删除关联产品的属性值
        List<PropertyValue> propertyValues = propertyValueRepository.findByPtid(id);
        propertyValueRepository.deleteAll(propertyValues);
        count = 1;
        return count;
    }
}
