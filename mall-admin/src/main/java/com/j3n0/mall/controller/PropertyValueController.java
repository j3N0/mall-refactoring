package com.j3n0.mall.controller;

import com.j3n0.mall.model.PropertyValue;
import com.j3n0.mall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> listByProduct(@PathVariable Long pid) {
        return propertyValueService.listByPid(pid);
    }

    @PutMapping("/propertyValues/{id}")
    public String update(@PathVariable Long id, @RequestBody PropertyValue propertyValue) {
        int count = propertyValueService.update(id, propertyValue);
        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
