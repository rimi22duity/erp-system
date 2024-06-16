package maks.erp.system.service;

import maks.erp.system.dto.ProductDto;
import maks.erp.system.model.product.Product;
import maks.erp.system.model.product.ProductImage;
import maks.erp.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private CategoryService categoryService;

    public void save(ProductDto productDto) throws IOException {
        ProductImage image = new ProductImage();
        image.setFileName(productDto.getImage().getOriginalFilename());
        image.setDocument(productDto.getImage().getBytes());

        Product product = Product.builder()
                .code(productDto.getCode())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .productCategory(categoryService.findCategoryById(productDto.getCategoryId()))
                .currency(productDto.getCurrency())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .image(image)
                .created(new Date())
                .updated(new Date())
                .build();

        productImageService.save(image);
        productRepository.save(product);
    }

    public void edit(long id, ProductDto productDto) throws IOException {
        ProductImage image = new ProductImage();
        image.setFileName(productDto.getImage().getOriginalFilename());
        image.setDocument(productDto.getImage().getBytes());

        Product dbProduct = findProductById(id);
        if(dbProduct != null) {
            dbProduct.setCode(productDto.getCode());
            dbProduct.setCurrency(productDto.getCurrency());
            dbProduct.setProductCategory(categoryService.findCategoryById(productDto.getCategoryId()));
            dbProduct.setPrice(productDto.getPrice());
            dbProduct.setTitle(productDto.getTitle());
            dbProduct.setDescription(productDto.getDescription());
            dbProduct.setQuantity(productDto.getQuantity());
            dbProduct.setImage(image);
            dbProduct.setUpdated(new Date());

            productImageService.save(image);
            productRepository.save(dbProduct);
        }
    }

    public Product findProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
