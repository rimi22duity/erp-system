package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author duity
 * @since 5/7/24
 */

@Entity
@Table
@Getter
@Setter
public class UserDocuments {

    @Id
    @SequenceGenerator(name = "userDocSeq", sequenceName = "userDocSeq", allocationSize = 1)
    @GeneratedValue(generator = "userDocSeq")
    private long id;

    private String nidNumber;
    private String birthCertNumber;
    private String passportNumber;
    private Date passportDateOfExpiry;
}