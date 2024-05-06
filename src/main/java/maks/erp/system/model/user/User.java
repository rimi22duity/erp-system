package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import maks.erp.system.enums.Gender;

import java.util.Date;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "userSeq", allocationSize = 1)
    @GeneratedValue(generator = "userSeq")
    private long id;

    private String username;
    private String firstName;
    private String lastName;

    private Date created;
    private Date updated;
    private Date birthDate;
    private Date joiningDate;

    private Gender gender;

    @OneToOne
    private DesignationType designation;
    @OneToOne
    private ContactInfo contactInfo;
    @OneToOne
    private ContactInfo emergencyContact;
}