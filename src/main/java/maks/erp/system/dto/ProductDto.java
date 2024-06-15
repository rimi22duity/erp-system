package maks.erp.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Currency;
import maks.erp.system.model.product.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @NotEmpty(message = "Title should not be empty")
    private String title;

    private String description;

    @NotNull
    private ProductCategory productCategory;

    @NotNull
    private Currency currency;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    private MultipartFile image;
}
