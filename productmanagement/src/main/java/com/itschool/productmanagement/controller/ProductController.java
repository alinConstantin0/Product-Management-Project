package com.itschool.productmanagement.controller;

import com.itschool.productmanagement.entities.ProductModel;
import com.itschool.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "products")
    public String displayProducts(Model model ) {
        List<ProductModel> productModels = productService.viewAllProducts();
        model.addAttribute("products",productModels);
        return "products";
    }


    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
