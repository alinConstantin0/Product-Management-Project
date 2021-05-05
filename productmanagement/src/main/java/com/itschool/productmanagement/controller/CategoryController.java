package com.itschool.productmanagement.controller;

import com.itschool.productmanagement.entities.CategoryModel;
import com.itschool.productmanagement.exceptions.CategoryNameException;
import com.itschool.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    public String displayCategories(Model model) {
        List<CategoryModel> categoryModels = categoryService.viewAllCategories();
        model.addAttribute("categories",categoryModels);
        return "categories";
    }

    @GetMapping("add-categoryB")
    public String addCategory(Model model) {
        model.addAttribute("newCategory",new CategoryModel());
        return "add-category";
    }

    @GetMapping("add-category")
    public String addingCategory(@ModelAttribute CategoryModel categoryModel,Model model) {
        try {
            categoryService.addCategory(categoryModel);
            return "redirect:/categories";
        } catch (CategoryNameException categoryNameException) {
            model.addAttribute("newCategory",categoryModel);
            model.addAttribute("categoryNameError",categoryNameException);
            return "add-category";
        }
    }

    @GetMapping("deleteCategory")
    public String deleteCategory(@RequestParam("id") int id){
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping("viewCategory")
    public String viewCategory(@RequestParam("id") int id, Model model) {
        CategoryModel categoryModel = categoryService.viewCategory(id);
        model.addAttribute("viewedCategory",categoryModel);
        return "view-category";
    }

    @GetMapping("editCategory")
    public String editCategory(@RequestParam int id, Model model) {
        CategoryModel categoryModel = categoryService.viewCategory(id);
        model.addAttribute("editedCategory",categoryModel);
        return "edit-category";
    }

    @GetMapping("edit-category")
    public String editingCategory(@ModelAttribute CategoryModel categoryModel) {
        categoryService.editCategory(categoryModel);
        return "redirect:/categories";
    }
}
