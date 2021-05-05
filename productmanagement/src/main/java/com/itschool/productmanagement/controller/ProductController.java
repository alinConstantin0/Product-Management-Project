package com.itschool.productmanagement.controller;

import com.itschool.productmanagement.entities.ProductModel;
import com.itschool.productmanagement.exceptions.DescriptionException;
import com.itschool.productmanagement.exceptions.PriceException;
import com.itschool.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping(path = "add-productB")
    public String addButton(Model model) {
        model.addAttribute("newProduct",new ProductModel());
        return "add-product";
    }

    @GetMapping(path="add-product")
    public String addProduct(@ModelAttribute ProductModel newProduct, Model model) {
        try {
            productService.addNewProduct(newProduct);
            return "redirect:/products";
        } catch (PriceException priceException){
            model.addAttribute("newProduct",newProduct);
            model.addAttribute("priceError",priceException.getMessage());
            return "add-product";
        } catch (DescriptionException descriptionException) {
            model.addAttribute("newProduct",newProduct);
            model.addAttribute("descriptionError",descriptionException.getMessage());
            return "add-product";
        }
    }

    @GetMapping(path = "deleteProduct")
    public String deleteProduct(@RequestParam ("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping(path = "viewProduct")
    public String viewProduct(@RequestParam ("id") int id, Model model  ) {
        ProductModel productModel= productService.viewProduct(id);
        model.addAttribute("viewedProduct",productModel);
        return "view-product";
    }

    @GetMapping(path="editProduct")
    public String editProduct(@RequestParam int id,Model model){
        ProductModel productModel = productService.viewProduct(id);
        model.addAttribute("edited",productModel);
        return "edit-product";
    }

    @GetMapping(path="edit-product")
    public String editedProduct(@ModelAttribute ProductModel editedModel){
        productService.editProduct(editedModel);
        return "redirect:/products";
    }
}
