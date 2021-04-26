package com.itschool.productmanagement.service;

import com.itschool.productmanagement.entities.ProductModel;
import com.itschool.productmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public ProductModel viewProduct(int id){
        Optional<ProductModel> optionalProductModel= productRepository.findById(id);
        return optionalProductModel.get();
    }

    public void editProduct(ProductModel editedModel){
        productRepository.save(editedModel);
    }
}
