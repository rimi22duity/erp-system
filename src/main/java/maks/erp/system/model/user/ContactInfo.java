package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author duity
 * @since 5/4/24
 */


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactInfo {

    @Id
    @SequenceGenerator(name = "contactInfoSeq", sequenceName = "contactInfoSeq", allocationSize = 1)
    @GeneratedValue(generator = "contactInfoSeq")
    private long id;

    private String phone;
    private String mobileNumber;
    private String email;

    @OneToOne
    private Address presentAddress;

    @OneToOne
    private Address permanentAddress;
}
