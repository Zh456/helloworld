package com.czxy.controller;

import com.czxy.domain.Category;
import com.czxy.domain.Product;
import com.czxy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ZHANGHUIqqqqqqqqqqqqqqqqqqqqq
 * @version v 1.0
 * @date 2019/6/24
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("findAll.action")
    public String findAll(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/admin/product/add.jsp";
    }

    @RequestMapping("add.action")
    public String addProduct(@RequestParam(required = false) MultipartFile file, Product product) throws IOException {
        String originalFilename = file.getOriginalFilename();
        product.setPimage("products/1/" + originalFilename);
        product.setPid(UUID.randomUUID().toString().substring(0, 6));
        product.setPdate(new Date());
        System.out.println(originalFilename);
        file.transferTo(new File("D:\\d12\\Spring\\exercise03\\src\\main\\webapp\\products\\1", originalFilename));
        categoryService.addProduct(product);
        return "profindAll.action";
    }

    @RequestMapping("profindAll.action")
    public String ProfindAll(Model model) {
        List<Product> productList = categoryService.ProfindAll();
        model.addAttribute("productList", productList);
        return "/admin/product/list.jsp";
    }

}
