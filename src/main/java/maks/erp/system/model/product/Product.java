package maks.erp.system.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Currency;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @SequenceGenerator(
            name = "productSeq",
            sequenceName = "productSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "productSeq")
    private long id;

    @NotEmpty
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    @OneToOne
    private ProductImage image;
}
