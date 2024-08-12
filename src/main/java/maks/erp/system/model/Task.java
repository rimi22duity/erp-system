package maks.erp.system.model;

import jakarta.persistence.*;
import maks.erp.system.model.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "taskSeq",
            sequenceName = "taskSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "taskSeq")
    private long id;

    private String title;
    private String description;

    @OneToMany
    private ArrayList<User> assigneeList;

    @OneToOne
    private User reportedBy;
    private Date eta;
    private Date completedOn;

    private Currency taskAllowanceCurrency;
    private double taskAllowance;

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
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
