package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.*;
import maks.erp.system.enums.Relationship;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmergencyContactInfo {

    @Id
    @SequenceGenerator(name = "emergencyContactInfoSeq", sequenceName = "emergencyContactInfoSeq", allocationSize = 1)
    @GeneratedValue(generator = "emergencyContactInfoSeq")
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Relationship relation;

    private String phone;
    private String mobileNumber;
}