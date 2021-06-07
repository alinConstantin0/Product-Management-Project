package com.itschool.productmanagement.service;

import com.itschool.productmanagement.entities.CategoryModel;
import com.itschool.productmanagement.exceptions.CategoryNameException;
import com.itschool.productmanagement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> viewAllCategories() {
        List<CategoryModel> categoryModels = categoryRepository.findAll();
        return categoryModels;
    }

    public void addCategory(CategoryModel categoryModel) {
        if (categoryModel.getName().length() > 25) {
            throw new CategoryNameException("Category name should be shorter than 25 characters");
        } else {
            categoryRepository.save(categoryModel);
        }
        System.out.println("Adding category.");
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
        System.out.println("Removing category with ID : " + id);
    }

    public CategoryModel viewCategory(int id){
        Optional<CategoryModel> optional= categoryRepository.findById(id);
        return optional.get();
    }

    public void editCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryModel);
        System.out.println("Editing category.");
    }

}
