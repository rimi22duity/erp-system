package maks.erp.system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
@ToString
public class Address {

    @Id
    @SequenceGenerator(name = "addressSeq", sequenceName = "addressSeq", allocationSize = 1)
    @GeneratedValue(generator = "addressSeq")
    private long id;

    private String road;
    private String thana;
    private String city;
    private String district;
    private String locationCode;
}
