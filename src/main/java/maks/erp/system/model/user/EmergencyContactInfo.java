package maks.erp.system.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import maks.erp.system.enums.Relationship;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyContactInfo {

    @Id
    @SequenceGenerator(name = "emergencyContactInfoSeq", sequenceName = "emergencyContactInfoSeq", allocationSize = 1)
    @GeneratedValue(generator = "emergencyContactInfoSeq")
    private long id;

    private String name;

    private Relationship relation;

    private String phone;
    private String mobileNumber;
}