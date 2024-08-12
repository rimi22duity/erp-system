package maks.erp.system.model;

import jakarta.persistence.*;
import lombok.*;
import maks.erp.system.enums.Currency;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "salarySeq", sequenceName = "salarySeq", allocationSize = 1)
    @GeneratedValue(generator = "salarySeq")
    private long id;

    private Currency currency;

    private double basic;
    private double conveyanceAllowance;
    private double medicalReimbursement;
    private double houseRent;

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
        if (!(o instanceof Salary)) return false;
        Salary salary = (Salary) o;
        return id == salary.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}