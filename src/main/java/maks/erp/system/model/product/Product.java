package maks.erp.system.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Currency;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @NotEmpty
    private String code;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Version
    private int version = 0;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
