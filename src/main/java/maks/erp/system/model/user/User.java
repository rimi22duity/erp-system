package maks.erp.system.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Religion;

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

    @NotBlank
    @Column(unique = true)
    private String username;
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Date created;
    private Date updated;
    private Date birthDate;
    private Date joiningDate;

    private Gender gender;

    @NotNull
    private double salary;

    private Religion religion;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @OneToOne
    private ContactInfo contactInfo;

    @OneToOne
    @JoinColumn(name = "present_address_id")
    private Address presentAddress;

    @OneToOne
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;

    @OneToOne
    private EmergencyContactInfo emergencyContact;

    @OneToOne
    private UserDocument userDocument;
}