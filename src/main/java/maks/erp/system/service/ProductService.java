package maks.erp.system.service;

import maks.erp.system.dto.ProductDto;
import maks.erp.system.model.product.Product;
import maks.erp.system.model.product.ProductImage;
import maks.erp.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageService productImageService;

    public void save(ProductDto productDto) throws IOException {
        ProductImage image = new ProductImage();
        image.setFileName(productDto.getImage().getOriginalFilename());
        image.setDocument(productDto.getImage().getBytes());

        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .productCategory(productDto.getProductCategory())
                .image(image)
                .build();

        productImageService.save(image);
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
