package com.j3n0.mall.service;

import com.j3n0.mall.model.Property;

import java.util.List;

public interface PropertyService {

    /**
     * 按分类查询Property
     */
    List<Property> listByCid(Long cid);

    /**
     * 查询Property
     */
    Property get(Long id);

    /**
     * 创建Property, 手动级联PropertyValue
     */
    int create(Property property);

    /**
     * 更新Property
     */
    int update(Long id, Property property);

    /**
     * 删除Property, 手动级联PropertyValue
     */
    int delete(Long id);
}
