package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.*;
import maks.erp.system.enums.Relationship;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmergencyContactInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "emergencyContactInfoSeq", sequenceName = "emergencyContactInfoSeq", allocationSize = 1)
    @GeneratedValue(generator = "emergencyContactInfoSeq")
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Relationship relation;

    private String phone;
    private String mobileNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Version
    private int version = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmergencyContactInfo)) return false;
        EmergencyContactInfo that = (EmergencyContactInfo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}