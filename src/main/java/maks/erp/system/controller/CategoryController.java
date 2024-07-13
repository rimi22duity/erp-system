package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.dto.CategoryDto;
import maks.erp.system.model.product.ProductCategory;
import maks.erp.system.service.CategoryService;
import maks.erp.system.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/categories")
    public String getCategories(ModelMap model) {
        model.put("categories", categoryService.getCategories());
        model.put("categoryDto", new CategoryDto());
        model.put("loggedInUser", securityService.getLoggedInUser());

        return "categories";
    }

    @PostMapping("/addCategory")
    public String saveCategory(@Valid @ModelAttribute CategoryDto categoryDto,
                               BindingResult result,
                               ModelMap model) {
        if(result.hasErrors()) {
            model.put("categoryDto", categoryDto);
            model.put("loggedInUser", securityService.getLoggedInUser());
            return "categories";
        }

        categoryService.save(categoryDto);
        return "redirect:/categories";
    }

    @GetMapping("/editCategory")
    public String showEditCategoryPage(@RequestParam("selectedCategoryId") long id,
                                       ModelMap model) {
        CategoryDto categoryDto = categoryService.mapToDto(
                categoryService.findCategoryById(id));
        model.put("categoryDto", categoryDto);
        model.put("categoryId", id);
        model.put("action", "Edit");
        model.put("loggedInUser", securityService.getLoggedInUser());

        return "category_details";
    }

    @PostMapping("/editCategory")
    public String editCategory(@RequestParam("selectedCategoryId") long id,
                               @Valid @ModelAttribute CategoryDto categoryDto,
                               BindingResult result,
                               ModelMap model) {

        if(result.hasErrors()) {
            model.put("categoryDto", categoryDto);
            model.put("categoryId", id);
            model.put("loggedInUser", securityService.getLoggedInUser());

            return "category_details";
        }

        categoryService.editCategory(id, categoryDto);

        return "redirect:/categories";
    }

    @GetMapping("/viewCategory")
    public String showCategoryDetails(@RequestParam("selectedCategoryId") long id,
                                      ModelMap model) {
        System.out.println("Inside showCategoryDetails");
        ProductCategory category = categoryService.findCategoryById(id);
        model.put("categoryDto", category);
        model.put("categoryId", id);
        model.put("action", "View");
        model.put("loggedInUser", securityService.getLoggedInUser());

        return "category_details";
    }
}
