package maks.erp.system.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Religion;
import maks.erp.system.model.LeaveInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "userSeq", allocationSize = 1)
    @GeneratedValue(generator = "userSeq")
    private long id;

    @NotBlank(message = "This field should not be empty!")
    @Column(unique = true)
    private String username;
    private String password;

    @NotBlank(message = "This field should not be empty!")
    private String firstName;

    @NotBlank(message = "This field should not be empty!")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private double salary;

    @Enumerated(EnumType.STRING)
    private Religion religion;

    @NotNull
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

    @OneToMany
    @JoinColumn(name = "leave_info_id")
    private List<LeaveInfo> leaveInfo;
}