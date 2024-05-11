package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duity
 * @since 5/7/24
 */

@Entity
@Table
@Getter
@Setter
public class UserDocument {

    @Id
    @SequenceGenerator(name = "userDocSeq",
            sequenceName = "userDocSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "userDocSeq")
    private long id;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String document;

//    private String nidNumber;
//    private String birthCertNumber;
//    private String passportNumber;
//    private Date passportDateOfExpiry;
}