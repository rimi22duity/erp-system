package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    @NotEmpty(message = "Title must not be empty")
    private String title;

    private String description;
}
