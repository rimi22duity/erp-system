package maks.erp.system.controller;

import jakarta.validation.Valid;
import maks.erp.system.dto.CategoryDto;
import maks.erp.system.dto.ProductDto;
import maks.erp.system.model.product.ProductCategory;
import maks.erp.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class ProductCreationController {

    @Autowired
    private ProductService productService;

    private String CRETE_PRODUCT_PAGE = "create_product";

    @GetMapping("/createProduct")
    public String getCreateProduct(ProductDto productDto, ModelMap model) {
        model.put("productDto", new ProductDto());
        return "create_product";
    }

    @PostMapping ("/createProduct")
    public String createProduct(@Valid @ModelAttribute ProductDto productDto,
                                BindingResult result,
                                ModelMap model,
                                RedirectAttributes redirectAttributes) throws IOException {

        if(result.hasErrors()) {
            System.out.println("Error occured");
            System.out.println(result.getAllErrors());
            model.put("productDto", productDto);
            return CRETE_PRODUCT_PAGE;
        }

        productService.save(productDto);
        model.put("productDto", new ProductDto());
        return "redirect:/createProduct";
    }

    @GetMapping("/products")
    public String getAllProducts(ModelMap model) {
        model.put("products", productService.getAllProducts());

        return "product_list";
    }
}
