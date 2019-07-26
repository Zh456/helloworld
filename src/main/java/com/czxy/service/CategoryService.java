package com.czxy.service;

import com.czxy.domain.Category;
import com.czxy.domain.Product;

import java.util.List;

/**
 * @author ZHANGHUI
 * @version v 1.0
 * @date 2019/6/24
 */
public interface CategoryService {
    List<Category> findAll();

    void addProduct(Product product);


    List<Product> ProfindAll();
}
