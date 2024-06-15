package maks.erp.system.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class ProductImage {

    @Id
    @SequenceGenerator(name = "productImageSeq",
            sequenceName = "productImageSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "productImageSeq")
    private long id;

    private String fileName;

    @Lob
    @Column(length = 100000)
    private byte[] document;
}