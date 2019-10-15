package com.j3n0.mall.service.impl;

import com.j3n0.mall.dao.ProductDAO;
import com.j3n0.mall.model.*;
import com.j3n0.mall.repository.CommentRepository;
import com.j3n0.mall.repository.ProductImageRepository;
import com.j3n0.mall.repository.PropertyValueRepository;
import com.j3n0.mall.service.ForeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForeProductServiceImpl implements ForeProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    PropertyValueRepository propertyValueRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<ForeHomeProduct> listHomeProducts(Long cid) {
        return productDAO.listForeHomeProducts(cid);
    }

    @Override
    public ForeProduct getForeProduct(Long pid) {
        ForeProduct foreProduct = new ForeProduct();
        // Todo 异常处理
        Product product = productDAO.findById(pid).orElseThrow(RuntimeException::new);
        List<PropertyValue> propertyValues = propertyValueRepository.findByPid(product.getId());
        List<Comment> comments = commentRepository.findByPid(product.getId());
        List<ProductImage> productImages = productImageRepository.findByPid(product.getId());

        foreProduct.setProduct(product);
        foreProduct.setProductImages(productImages);
        foreProduct.setComments(comments);
        foreProduct.setPropertyValues(propertyValues);
        return foreProduct;
    }

    @Override
    public List<List<ForeHomeProduct>> listRecommendProducts(Long cid) {
        List<ForeHomeProduct> products = productDAO.listForeHomeProducts(cid);

        return splitProducts(products);
    }

    /*
    将产品按行切分
    */
    private List<List<ForeHomeProduct>> splitProducts(List<ForeHomeProduct> products) {
        List<List<ForeHomeProduct>> productsByRow =  new ArrayList<>();
        int PRODUCT_NUMBER_EACH_ROW = 8;
        int size = products.size();
        int countStep = (size + PRODUCT_NUMBER_EACH_ROW - 1) / PRODUCT_NUMBER_EACH_ROW;
        for (int i = 0; i < countStep; i++) {
            productsByRow.add(
                    products.stream()
                            .skip(i * PRODUCT_NUMBER_EACH_ROW)
                            .limit(PRODUCT_NUMBER_EACH_ROW)
                            .collect(Collectors.toList()));
        }
        return productsByRow;
    }
}
