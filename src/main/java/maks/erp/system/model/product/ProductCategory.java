package maks.erp.system.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @SequenceGenerator(name = "categorySeq",
            sequenceName = "categorySeq",
            allocationSize = 1)
    @GeneratedValue(generator = "categorySeq")
    private long id;

    @NotEmpty
    private String title;
    private String description;
}
