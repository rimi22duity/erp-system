package maks.erp.system.service;

import maks.erp.system.dto.CategoryDto;
import maks.erp.system.dto.ProductDto;
import maks.erp.system.model.product.ProductCategory;
import maks.erp.system.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    public List<ProductCategory> getCategories() {
        return productCategoryRepository.findAll();
    }

    public void save(CategoryDto categoryDto) {
        ProductCategory productCategory = ProductCategory.builder()
                .title(categoryDto.getTitle())
                .description(categoryDto.getDescription())
                .build();

        productCategoryRepository.save(productCategory);
    }

    public ProductCategory findCategoryById(long id) {
        Optional<ProductCategory> optional = productCategoryRepository.findById(id);
        return  optional.isPresent() ? optional.get() : null;
    }

    public CategoryDto mapToDto(ProductCategory category) {
        return CategoryDto.builder()
                .title(category.getTitle())
                .description(category.getDescription())
                .build();
    }

    public void editCategory(long id, CategoryDto categoryDto) {
        Optional<ProductCategory> optional = productCategoryRepository.findById(id);
        if(optional.isPresent()) {
            ProductCategory category = optional.get();
            category.setTitle(categoryDto.getTitle());
            category.setDescription(categoryDto.getDescription());

            productCategoryRepository.save(category);
        }
    }
}
