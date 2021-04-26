package com.itschool.productmanagement.service;

import com.itschool.productmanagement.entities.ProductModel;
import com.itschool.productmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> viewAllProducts() {
        List<ProductModel> productModels = productRepository.findAll();
        return productModels;
    }

    public void addNewProduct(ProductModel productModel) {
        productRepository.save(productModel);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void editProduct(){

    }
}
