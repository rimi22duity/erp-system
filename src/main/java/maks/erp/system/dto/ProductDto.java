package maks.erp.system.dto;

import jakarta.validation.constraints.Min;
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

    @NotEmpty(message = "Code should not be empty")
    private String code;

    @NotNull
    @Min(value = 1, message = "Please select a category")
    private long categoryId;

    @NotNull(message = "Currency should not be empty")
    private Currency currency;

    @NotNull(message = "Price should not be empty")
    private double price;

    @NotNull(message = "Quantity should not be empty")
    private int quantity;

    private MultipartFile image;
}
