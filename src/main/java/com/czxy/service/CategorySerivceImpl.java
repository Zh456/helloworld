package com.czxy.service;

import com.czxy.dao.CategoryMapper;
import com.czxy.dao.ProductMapper;
import com.czxy.domain.Category;
import com.czxy.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHANGHUI
 * @version v 1.0
 * @date 2019/6/24
 */
@Service
public class CategorySerivceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = categoryMapper.selectAll();
        return categoryList;
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public List<Product> ProfindAll() {
        List<Product> productList = productMapper.selectAll();
        return productList;
    }
}
