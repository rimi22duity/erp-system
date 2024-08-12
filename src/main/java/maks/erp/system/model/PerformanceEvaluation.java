package maks.erp.system.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author duity
 * @since 5/4/24
 */
@Table
@Entity
@Getter
@Setter
public class PerformanceEvaluation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "performanceEvalSeq",
            sequenceName = "performanceEvalSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "performanceEvalSeq")
    private long id;

    private int numberOfSalesDone;
    private int numberOfInProgress;

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
        if (!(o instanceof PerformanceEvaluation)) return false;
        PerformanceEvaluation that = (PerformanceEvaluation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
