package maks.erp.system.repository;

import maks.erp.system.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends JpaRepository<Product, Long> {
}
