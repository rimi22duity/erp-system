package maks.erp.system.service;

import maks.erp.system.model.product.ProductImage;
import maks.erp.system.repository.ProductImageRepository;
import maks.erp.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;
    public void save(ProductImage image) {
        productImageRepository.save(image);
    }
}
