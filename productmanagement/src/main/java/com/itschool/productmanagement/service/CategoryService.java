package com.itschool.productmanagement.service;

import com.itschool.productmanagement.entities.CategoryModel;
import com.itschool.productmanagement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService {

    @Autowired
   private CategoryRepository categoryRepository;

    public List<CategoryModel> viewAllCategories() {
        List<CategoryModel> categoryModels = categoryRepository.findAll();
        return categoryModels;
    }

    public void addCategory(CategoryModel categoryModel) {

    }

    public void deleteCategory() {

    }

    public void editCategory() {
    
    }

}
