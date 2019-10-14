package com.j3n0.mall.controller;

import com.j3n0.mall.model.Category;
import com.j3n0.mall.model.Property;
import com.j3n0.mall.service.CategoryService;
import com.j3n0.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public List<Property> listByCategory(@PathVariable Long cid) {
        return propertyService.listByCid(cid);
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable Long id) {
        return propertyService.get(id);
    }

    @PostMapping("/properties")
    public String create(@RequestBody Property property) {
        int count = propertyService.create(property);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @PutMapping("/properties/{id}")
    public String update(@PathVariable Long id, @RequestBody Property property) {
        int count = propertyService.update(id, property);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable Long id) {
        int count = propertyService.delete(id);

        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
