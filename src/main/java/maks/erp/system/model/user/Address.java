package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @SequenceGenerator(name = "addressSeq",
            sequenceName = "addressSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "addressSeq")
    private long id;

    private String road;
    private String thana;
    private String city;
    private String district;
    private String postalCode;
}
