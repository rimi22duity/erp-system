package maks.erp.system.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Religion;
import maks.erp.system.model.JobInformation;
import maks.erp.system.model.LeaveInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table (
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"})
        }
)
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

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Religion religion;

    @OneToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;

    @OneToOne
    @JoinColumn(name = "emergency_contact_info_id")
    private EmergencyContactInfo emergencyContact;

    @OneToOne
    @JoinColumn(name = "present_address_id")
    private Address presentAddress;

    @OneToOne
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;

    @OneToOne
    @JoinColumn(name = "user_document_id")
    private UserDocument document;

    @OneToOne
    @JoinColumn(name = "job_info_id")
    private JobInformation jobInformation;

    @OneToMany
    @JoinColumn(name = "leave_info_id")
    private List<LeaveInfo> leaveInfo;

    @Transient
    private String fullName;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}